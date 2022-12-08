package com.example.demo.JVM;

public class MyRunnable implements Runnable {

    public void run() {
        methodOne();
    }

    public void methodOne() {
        int localVariable1 = 45;

        MySharedObject localVariable2 =
                MySharedObject.sharedInstance;
        System.out.println("localVariable2.object2=" + localVariable2.object2);
        System.out.println(Thread.currentThread().getName() + "localVariable2.member1" + localVariable2.member1);
        localVariable2.object2 = new Integer(122);
        localVariable2.member1 = 444l;
        System.out.println("localVariable2.object2="+localVariable2.object2); //线程共有，一个线程改变了，其他线程会受影响
        System.out.println(Thread.currentThread().getName() + "localVariable2.member1" + localVariable2.member1);//线程私有，一个线程改变了，其他线程不会受影响

        methodTwo();
    }

    public void methodTwo() {
        Integer localVariable1 = new Integer(99);
//        System.out.println(localVariable1);
    }
}

