package com.example.demo.DesignMode;

//模板方法类，将相同代码放在抽象父类中，把不同代码放入子类，通过对子类不同实现，扩展不同的行为
public class TemplateTest {
    public static void main(String[] args) {
        Refrigerator refrigerator = new Apple();
        refrigerator.open();
        refrigerator.put();
        refrigerator.close();
    }
}

abstract class Refrigerator{
    public void open(){
        System.out.println("打开冰箱");
    }

    public abstract void put();

    public void close(){
        System.out.println("关闭冰箱");
    }
}

class Banana extends Refrigerator{
    @Override
    public void put() {
        System.out.println("放香蕉");
    }
}

class Apple extends Refrigerator{
    @Override
    public void put() {
        System.out.println("放苹果");
    }
}