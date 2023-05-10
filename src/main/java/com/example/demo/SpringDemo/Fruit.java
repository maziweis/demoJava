package com.example.demo.SpringDemo;

public interface Fruit {
    void eat();
}

class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("Apple");
    }
}

class Orange implements Fruit {
    @Override
    public void eat() {
        System.out.println("Orange");
    }
}

class Factory {
    public static Fruit getInstance(String ClassName) {
        Fruit f = null;
        try {
            f = (Fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}

class client {
    public static void main(String[] args) {
        Fruit f = Factory.getInstance("com.example.demo.SpringDemo.Apple");
        if (f != null) {
            f.eat();
        }
    }
}

