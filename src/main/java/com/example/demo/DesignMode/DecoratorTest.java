package com.example.demo.DesignMode;

//装饰器模式：动态的给一个对象增加一些额外的功能，同时不改变其结构
public class DecoratorTest {
    public static void main(String[] args) {
        Person person = new Person("老王");
        DecoratorBase jacket = new Jacket(person);
        DecoratorBase hat = new Hat(jacket);
        hat.show();
    }
}

//顶层对象，定义行为
interface IPerson {
    void show();
}

//定义装饰器超类
abstract class DecoratorBase implements IPerson {
    IPerson iPerson;

    public DecoratorBase(IPerson iperson){
        System.out.println("DecoratorBase 构造");
        this.iPerson = iperson;
    }
    @Override
    public void show() {
        iPerson.show();
    }
}

class Jacket extends DecoratorBase{
    public Jacket(IPerson iperson){
        super(iperson);
        System.out.println("Jacket 构造");
    }

    @Override
    public void show() {
        //执行已有功能
        iPerson.show();
        //定义新行为
        System.out.println("穿上夹克");
    }
}

class Hat extends DecoratorBase{
    public Hat(IPerson iperson){
        super(iperson);
        System.out.println("Hat 构造");
    }

    @Override
    public void show() {
        iPerson.show();
        System.out.println("带上帽子");
    }
}

class Person implements IPerson {
    private String name;

    public Person(String name){
        this.name = name;
    }
    @Override
    public void show() {
        System.out.println("我是" + name);
    }
}
