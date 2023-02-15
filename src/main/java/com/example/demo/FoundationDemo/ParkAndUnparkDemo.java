package com.example.demo.FoundationDemo;

import java.util.concurrent.locks.LockSupport;

//先调用unpark，然后调用park
public class ParkAndUnparkDemo {
    public static void main(String[] args) {
        MyThreadPark myThread = new MyThreadPark(Thread.currentThread());
        myThread.start();
        try {
            // 主线程睡眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }
}
class MyThreadPark extends Thread {
    private Object object;

    public MyThreadPark(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before unpark");
        // 释放许可
        LockSupport.unpark((Thread) object);
        System.out.println("after unpark");
    }
}