package com.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InterruptExample {

    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("thread run");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (!interrupted()){
                System.out.println("thread run 2");
            }
            System.out.println("thread2 end");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        test4();
        System.out.println("main run");
    }

    static void test4(){
        ExecutorService executorService = Executors.newCachedThreadPool();
       Future future = executorService.submit(()->{
            try {
                Thread.sleep(100);
                System.out.println("thread run");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        future.cancel(true); //停止当前线程，睡眠不会报异常
    }
    static void test3(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{  //开启匿名线程
            try {
                Thread.sleep(100);
                System.out.println("thread run");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        executorService.shutdownNow(); //立马停止所有线程，会报异常
    }
    static void test2(){
        MyThread2 thread2 = new MyThread2();
        thread2.start();
        thread2.interrupt();
    }
    static void test1(){
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        myThread1.interrupt();
        System.out.println("main run");
    }

}
