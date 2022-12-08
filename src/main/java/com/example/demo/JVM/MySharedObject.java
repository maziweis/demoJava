package com.example.demo.JVM;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MySharedObject {

    //static variable pointing to instance of MySharedObject

    public static final MySharedObject sharedInstance =
            new MySharedObject();


    //member variables pointing to two objects on the heap

    public Integer object2 = new Integer(22);//线程共有，一个线程改变了，其他线程会受影响 ，引用类型在堆上，属于共享
    public Integer object4 = new Integer(44);

    public long member1 = 12345;//线程私有，一个线程改变了，其他线程不会受影响，在线程栈上，每个线程一份
    public long member2 = 67890;

    public static void main(String[] args) {
        ExecutorService executors = Executors.newCachedThreadPool();
        executors.execute(new MyRunnable());
        executors.execute(new MyRunnable());
    }
}

