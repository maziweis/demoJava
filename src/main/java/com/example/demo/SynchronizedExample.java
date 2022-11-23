package com.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample {
    //作用于同一个对象
    public void test1(){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.println(i+ "");
            }
        }
    }
    //作用于同一个对象
    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "");
        }
    }
    //作用于同一个类，也就是说两个线程调用同一个类的不同对象上的这种同步语句，也会进行同步。
    public void test3(){
        synchronized (SynchronizedExample.class){
            for (int i = 0; i < 10; i++) {
                System.out.println(i+ "");
            }
        }
    }
    //同步一个静态方法,作用于同一个类
    public synchronized static void test4() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "");
        }
    }
    public static void main(String[] args) {
        SynchronizedExample example = new SynchronizedExample();
        SynchronizedExample example1 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->example.test1());
        executorService.execute(()->example1.test1());
        executorService.shutdown();
    }
}
