package com.example.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("Annotator")
public class AbstractQueuedSynchronizerDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);

        MyThreadA t1 = new MyThreadA("t1", lock);
        MyThreadA t2 = new MyThreadA("t2", lock);
        MyThreadA t3 = new MyThreadA("t3", lock);
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThreadA extends Thread{
    private Lock lock;

    public MyThreadA(String name, Lock lock){
        super(name);
        this.lock = lock;
    }

    public void run(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread()+"running");
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }finally {
            lock.unlock();
        }
    }
}