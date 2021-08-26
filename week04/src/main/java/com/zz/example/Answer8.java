package com.zz.example;

/**
 * @author sp0038
 * @date 2021/8/24
 */
public class Answer8 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 重写 Thread的start方法(不知道算不算)
        new TaskThread().start();
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

    static class TaskThread extends Thread {
        @Override
        public synchronized void start() {
            run();
        }

        @Override
        public void run() {
            try {
                int result1 = sum();
                // 确保  拿到result 并输出
                System.out.println("异步计算结果为：" + result1);
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
