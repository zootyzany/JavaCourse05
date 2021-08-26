package com.zz.example;

import java.util.concurrent.locks.LockSupport;

/**
 * @author sp0038
 * @date 2021/8/24
 */
public class Answer5 {

    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        long start = System.currentTimeMillis();
        // 使用LockSupport.park()
        Thread thread = new Thread(() -> {
            try {
                int result1 = sum();
                // 确保  拿到result 并输出
                System.out.println("异步计算结果为：" + result1);
                Thread.sleep(3000);
                LockSupport.unpark(currentThread);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        LockSupport.park();
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
