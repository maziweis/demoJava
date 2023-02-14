package com.example.demo.DesignMode;

//策略模式：定义一系列算法，将每个算法封装起来，使他们之间可以相互替换
public class StrategyTest {
    public static void main(String[] args) {
        ITrip trip = new Trip(new Drive());
        trip.going();
    }
}

interface ITrip{
    void going();
}

class Trip implements ITrip{
    private ITrip iTrip;
    public Trip(ITrip iTrip) {
        this.iTrip = iTrip;
    }

    @Override
    public void going() {
        iTrip.going();
    }
}

class Bike implements ITrip{
    @Override
    public void going() {
        System.out.println("骑自行车");
    }
}

class Drive implements ITrip{
    @Override
    public void going() {
        System.out.println("开车");
    }
}