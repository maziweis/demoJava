package com.example.demo.DesignMode;

//代理模式：给某一个对象提供一个代理，由代理对象控制对原对象的引用
public class ProxyTest {
    public static void main(String[] args) {
        IAirTicket ticket = new ProxyAirTicket();
        ticket.buy();
    }
}

//售票口
interface IAirTicket{
    void buy();
}

//定义机场售票
class AirTicket implements IAirTicket{
    @Override
    public void buy() {
        System.out.println("买票");
    }
}

//定义代理售票平台
class ProxyAirTicket implements IAirTicket{
    private AirTicket airTicket;
    public ProxyAirTicket(){
        airTicket = new AirTicket();
    }
    @Override
    public void buy() {
        airTicket.buy();
        System.out.println("售后服务");
    }
}
