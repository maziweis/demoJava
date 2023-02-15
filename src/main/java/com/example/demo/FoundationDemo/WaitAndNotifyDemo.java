package com.example.demo.FoundationDemo;

public class WaitAndNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    //由于先调用了notify，再调用的wait，此时主线程还是会一直阻塞。
    public static void test1()throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        //主线程睡眠3S
        Thread.sleep(3000);
        synchronized (myThread){
            try {
                System.out.println("before wait");
                myThread.wait();
                //阻塞主线程
                System.out.println("after wait");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void test()throws InterruptedException {
        MyThread myThread = new MyThread();
        synchronized (myThread) {//获取锁
            try {
                myThread.start();
                // 主线程睡眠3s
                Thread.sleep(3000);
                System.out.println("before wait");
                // 阻塞主线程,并释放锁
                myThread.wait();
                System.out.println("after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class MyThread extends Thread {

    public void run() {
        synchronized (this) {
            System.out.println("before notify");
            notify();
            System.out.println("after notify");
        }
    }
}