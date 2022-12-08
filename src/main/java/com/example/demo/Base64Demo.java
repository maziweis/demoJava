package com.example.demo;

import java.util.Base64;

public class Base64Demo {

    public static void main(String[] args) throws Exception {
        test1();
    }

    static void test1(){
        System.out.println("hello, world");
        int  j=0;
        int k= j++  + ++j;
        int k1= ++j  + j++;
        System.out.println(k);
        System.out.println(k1);
        for (int i = 0; i < 10; ) {
            System.out.println(i++);
        }
        for (int i = 0; i < 10;) {
            System.out.println(++i);
        }
    }

    static void test() throws Exception{
        String s = Base64.getEncoder().encodeToString("some string".getBytes("utf-8"));
        System.out.println(s);
        byte[] decode = Base64.getDecoder().decode(s);
        System.out.println(new String(decode,"utf-8"));
    }
}
