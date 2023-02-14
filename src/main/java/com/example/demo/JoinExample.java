package com.example.demo;

public class JoinExample {

    private class A extends Thread{
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class B extends Thread{
        private A a;

        B(A a){
            this.a=a;
        }

        @Override
        public void run() {
            try {
                System.out.println("B-");
                a.join();
                System.out.println("B+");
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public void test(){
        A a = new A();
        B b= new B(a);
        b.start();
        a.start();
    }

    public static void main(String[] args) {
        JoinExample joinExample = new JoinExample();
        joinExample.test();
    }
}
