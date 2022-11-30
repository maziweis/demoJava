package com.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private int m;

    public int inc() {
        return m + 1;
    }

    public static void main(String[] args)throws Exception {
//        Main.classTest();
//        Main.SuperTest();
        Main.FinalTest();
        System.out.println("main");
    }

    public static void FinalTest() {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            FinalDemo.writer();
        });
        service.execute(()->{
            try {
                FinalDemo.reader();//可能抛异常，demo为null
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        service.shutdown();
    }
    public static void SuperTest(){
        Son s= new Son();
        Parent p = new Son();
        Parent p1 =new Parent();
//        p.test1();
        p1.test1();
//        s.test();
    }
    public static void classTest() throws Exception {
        Class userClass = new User().getClass();
        // 获取Class对象的三种方式
        System.out.println("根据类名:  \t" + User.class);
        System.out.println("根据对象:  \t" + new User().getClass());
        System.out.println("根据全限定类名:\t" + Class.forName("com.example.demo.User"));
        // 常用的方法
        System.out.println("获取全限定类名:\t" + userClass.getName());
        System.out.println("获取类名:\t" + userClass.getSimpleName());
        System.out.println("实例化:\t" + userClass.newInstance());
    }
}