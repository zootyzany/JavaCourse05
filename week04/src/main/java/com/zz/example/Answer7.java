package com.zz.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author sp0038
 * @date 2021/8/24
 */
public class Answer7 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        long start = System.currentTimeMillis();
        // countDownLatch
        Thread thread = new Thread(() -> {
            try {
                int result1 = sum();
                // 确保  拿到result 并输出
                System.out.println("异步计算结果为：" + result1);
                Thread.sleep(3000);
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        cyclicBarrier.await();
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
