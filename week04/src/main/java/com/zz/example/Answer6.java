package com.zz.example;

import java.util.concurrent.CountDownLatch;

/**
 * @author sp0038
 * @date 2021/8/24
 */
public class Answer6 {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        // countDownLatch
        Thread thread = new Thread(() -> {
            try {
                int result1 = sum();
                // 确保  拿到result 并输出
                System.out.println("异步计算结果为：" + result1);
                Thread.sleep(3000);
                countDownLatch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        countDownLatch.await();
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
