package com.example.demo.Proxy.Demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {
    private Object target;

    public ProxyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理调用处理器0");
        return method.invoke(target, args);
    }

    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        Subject proxy = (Subject) Proxy
                .newProxyInstance(subject.getClass().getClassLoader(),
                        subject.getClass().getInterfaces(),
                        new ProxyInvocationHandler(subject));
        proxy.sayHello();
    }
}
