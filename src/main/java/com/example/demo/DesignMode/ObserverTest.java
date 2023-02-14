package com.example.demo.DesignMode;

import java.util.ArrayList;
import java.util.List;
//观察者模式，被观察者发生改变时，相关依赖得到通知，并被自动更新，也叫发布-订阅模式
public class ObserverTest {
    public static void main(String[] args) {
        Observer concreteObserver1 = new ConcreteObserver("老瓦");
        Observer concreteObserver2 = new ConcreteObserver("java");
        Subject concreteSubject = new ConcreteSubject();
        concreteSubject.attach(concreteObserver1);
        concreteSubject.attach(concreteObserver2);
        concreteSubject.notify("更新了");
        concreteSubject.detach(concreteObserver1);
        concreteSubject.notify("又更新了");
    }
}

//观察者
interface Observer{
    void update(String message);
}

//具体观察者（消息接受方）
class ConcreteObserver implements Observer{
    private String name;

    public ConcreteObserver(String name){
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + ": " + message);
    }
}

//被观察者
interface Subject{
    void attach(Observer observer);
    void detach(Observer observer);
    void notify(String message);
}
//具体被观察者 （消息发布方）
class ConcreteSubject implements Subject{

    public List<Observer> observers = new ArrayList<>();
    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}