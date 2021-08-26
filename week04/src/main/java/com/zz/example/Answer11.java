package com.zz.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author sp0038
 * @date 2021/8/24
 */
public class Answer11 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        // 用户 CompletableFuture的runAsync
        CompletableFuture sf = CompletableFuture.runAsync(() -> {
            try {
                int result1 = sum();
                // 确保  拿到result 并输出
                Thread.sleep(3000);
                System.out.println("异步计算结果为：" + result1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        sf.get();
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
