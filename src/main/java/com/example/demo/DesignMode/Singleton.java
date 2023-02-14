package com.example.demo.DesignMode;

public class Singleton {
    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1==instance2);
    }
}
