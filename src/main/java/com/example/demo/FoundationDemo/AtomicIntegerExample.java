package com.example.demo.FoundationDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    private AtomicInteger count = new AtomicInteger();
    volatile int i =0;
    public void increment(){
        count.incrementAndGet();
    }

    public int getCount(){
        return count.get();
    }

    public void add(){
        i++;
    }

    public static void main(String[] args)  throws InterruptedException {
        final int threadSize = 1000;
        AtomicIntegerExample example = new AtomicIntegerExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(()->{
                example.increment();
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        int count = example.getCount();
        System.out.println(count);//1000
        System.out.println(example.i);//998 加volatile也不行

    }
}
