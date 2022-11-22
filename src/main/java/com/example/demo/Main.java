package com.example.demo;

public class Main {

    private int m;

    public int inc() {
        return m + 1;
    }

    public static void main(String[] args)throws Exception {
        new Main().classTest();
        Sun s= new Sun();
        System.out.println("main");
    }
    public void classTest() throws Exception {
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