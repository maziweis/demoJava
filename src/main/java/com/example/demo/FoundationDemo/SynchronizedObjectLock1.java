package com.example.demo.FoundationDemo;

public class SynchronizedObjectLock1 implements Runnable {
    static SynchronizedObjectLock1 ins = new SynchronizedObjectLock1();

    Object block1 = new Object();
    Object block2 = new Object();

    @Override
    public void run() {
        synchronized (block1){
            System.out.println("block1锁,我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("block1锁,"+Thread.currentThread().getName() + "结束");
        }
        synchronized (block2){
            System.out.println("block2锁,我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("block2锁,"+Thread.currentThread().getName() + "结束");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(ins);
        Thread thread1 = new Thread(ins);
        thread.start();
        thread1.start();
        System.out.println("main");
    }


}
