package com.zz.example;

/**
 * @author sp0038
 * @date 2021/8/24
 */
public class Answer2 {
    private static Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        // 使用wait/notify的方式
        Thread thread = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    int result1 = sum();
                    // 确保  拿到result 并输出
                    System.out.println("异步计算结果为：" + result1);
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                LOCK.notify();
            }
        });
        thread.start();
        synchronized (LOCK) {
            LOCK.wait();
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
