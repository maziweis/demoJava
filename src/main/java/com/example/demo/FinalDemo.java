package com.example.demo;

public class FinalDemo {

    private int a;//普通域
    private final int b;//final域
    private  static FinalDemo finalDemo;



    public FinalDemo(){
        a=1;
        b=2;
        finalDemo = this;
    }

    public static void writer(){
        finalDemo = new FinalDemo();
    }

    public static void reader(){
        FinalDemo demo = finalDemo;
        int a = demo.a;
        int b = demo.b;
        System.out.println("a="+a+",b="+b);

    }


}
