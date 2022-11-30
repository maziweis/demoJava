package com.example.demo;

public class Son extends Parent{

    Son(){
        System.out.println("s constructor");
    }
    static {
        System.out.println("static s");
    }
    {
        System.out.println("s kong");
    }

    public void test(){
        System.out.println("son");
    }
    public void test2(){
        System.out.println("son2");
    }
}
