package com.example.demo.Proxy.Demo;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Subject proxy = (Subject) Proxy
                .newProxyInstance(Test.class.getClassLoader(),
                        new Class[]{Subject.class},
                        new ProxyInvocationHandler1());
        String s = proxy.sayHello();
        System.out.println(s);
    }
}
