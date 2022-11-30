package com.example.demo;

public class Parent {

    Parent(){
        System.out.println("p con");
    }
    static {
        System.out.println("static p");
    }
    {
        System.out.println("p kong");
    }

    public void test(){
        System.out.println("parent");
    }
    public void test1(){
        test();
        System.out.println("parent1");
    }
}
