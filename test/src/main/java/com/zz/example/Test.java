package com.zz.example;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sp0038
 * @date 2021/8/12
 */
public class Test {
    private static volatile Thread thread;

    public static void main(String[] args) throws InterruptedException {
        thread = new Thread(() -> {
            System.out.println("线程1开始!");
            LockSupport.park();
            System.out.println("线程1执行!");
        });
        thread.start();
        Thread.sleep(1000);

        new Thread(() -> {
            System.out.println("线程2开始!");
            LockSupport.unpark(thread);
        }).start();

        Thread.sleep(1000);
        System.out.println("结束了!");
    }

    public void lock() {
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println("test");
        } finally {
            lock.unlock();
        }
    }

    public void tryLock() {
        ReentrantLock lock = new ReentrantLock();
        try {
            // nonfairTryAcquire
            boolean flag = lock.tryLock();
            if (!flag) {
                System.out.println("Don't get lock!");
                return;
            }
        } finally {
            lock.unlock();
        }
    }
}

