package com.example.demo;

public class SynchronizedObjectLock implements Runnable {
    static SynchronizedObjectLock ins = new SynchronizedObjectLock();
    @Override
    public void run() {
        synchronized (this){
            System.out.println("我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(ins);
        Thread thread1 = new Thread(ins);
        thread.start();
        thread1.start();
    }


}
