package com.example.demo.FoundationDemo;

import java.util.concurrent.locks.LockSupport;
//使用park/unpark实现线程同步 上例是先调用park，然后调用unpark
public class ParkAndUnparkDemo1 {
    public static void main(String[] args) {
        MyThreadPark1 myThread = new MyThreadPark1(Thread.currentThread());
        myThread.start();
        System.out.println("before park");//1
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");//4
    }
}

class MyThreadPark1 extends Thread {
    private Object object;

    public MyThreadPark1(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before unpark");//2
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取blocker
        System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));//3
        // 释放许可
        LockSupport.unpark((Thread) object);
        // 休眠500ms，保证先执行park中的setBlocker(t, null);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 再次获取blocker
        System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));//5

        System.out.println("after unpark");

    }
}