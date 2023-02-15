package com.example.demo.FoundationDemo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    //可重入锁又名递归锁
    public synchronized void doSomething(){
        System.out.println("doSomething");
        doOther();
    }

    public synchronized void doOther(){
        System.out.println("doOther");
    }




    //------------------------------悲观锁------------------------------
    //synchronized
    public synchronized void test(){

    }

    //ReentrantLock
    private ReentrantLock lock = new ReentrantLock();//需要保证多个线程使用的是同一个锁

    public void modifyPublicResources(){
        lock.lock();
        //操作同步资源
        lock.unlock();
    }

    //--------------------------------乐观锁----------------------------
    private AtomicInteger atomicInteger = new AtomicInteger();//需要保证多个线程使用的是同一个AtomicInteger
    public void test2(){
        atomicInteger.incrementAndGet();//执行自增1
    }
}
