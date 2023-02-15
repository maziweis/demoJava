package com.example.demo.FoundationDemo;

import java.util.concurrent.locks.LockSupport;
//在主线程调用park阻塞后，在myThread线程中发出了中断信号，此时主线程会继续运行，
// 也就是说明此时interrupt起到的作用与unpark一样。
public class InterruptDemo {
    public static void main(String[] args) {

        MyThreadInterrupt myThread = new MyThreadInterrupt(Thread.currentThread());
        myThread.start();
        System.out.println("before park");//1
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");//4
    }
}
class MyThreadInterrupt extends Thread {
    private Object object;

    public MyThreadInterrupt(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before interrupt");//2
        try {
            // 休眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = (Thread) object;
        // 中断线程
        thread.interrupt();
        System.out.println("after interrupt");//3
    }
}