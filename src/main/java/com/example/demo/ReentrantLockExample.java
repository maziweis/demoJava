package com.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private Lock lock = new ReentrantLock();//ReentrantLock 是 java.util.concurrent(J.U.C)包中的锁。

    public static void main(String[] args) {
        ReentrantLockExample lockExample = new ReentrantLockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()-> lockExample.test1());
        executorService.execute(()-> lockExample.test1());
    }

    public void test1(){
        lock.lock();
        try{
            for (int i = 0; i < 10; i++) {
                System.out.println(i + "");
            }
        }finally {
            lock.unlock();//确保释放锁，避免死锁
        }
    }
}
