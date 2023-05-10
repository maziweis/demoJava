package com.example.demo.Proxy.Demo;

public class SubjectImpl implements Subject {
    @Override
    public String sayHello() {
        System.out.println("Hello");
        return "success";
    }
}
