package com.zz.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sp0038
 * @date 2021/8/24
 */
public class Answer3 {

    private static Lock LOCK = new ReentrantLock();
    private static Condition CONDITION = LOCK.newCondition();

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        LOCK.lock();
        try {
            // 使用lock/condition 的方式

            Thread thread = new Thread(() -> {
                LOCK.lock();
                try {
                    int result1 = sum();
                    // 确保  拿到result 并输出
                    System.out.println("异步计算结果为：" + result1);
                    Thread.sleep(3000);
                    CONDITION.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    LOCK.unlock();
                }

            });
            thread.start();
            CONDITION.await();
        } finally {
            LOCK.unlock();
        }
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}
