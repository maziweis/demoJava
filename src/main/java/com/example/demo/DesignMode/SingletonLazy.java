package com.example.demo.DesignMode;

public class SingletonLazy {

    private static SingletonLazy singletonLazy;

    public static synchronized SingletonLazy getSingletonLazy(){
        if(singletonLazy==null){
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
