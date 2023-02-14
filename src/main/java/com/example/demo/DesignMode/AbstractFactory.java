package com.example.demo.DesignMode;

public class AbstractFactory {

    public static void main(String[] args) {
        AbstractFactorys abstractFactorys = new BeerFactory();
        Product product = abstractFactorys.getProduct(Hans.class);
        System.out.println(product.getPrice());
    }
}


abstract class AbstractFactorys {

    public abstract Product getProduct(Class clazz);
}

class CoffeeFactory extends AbstractFactorys{
    @Override
    public Product getProduct(Class clazz) {
        switch (clazz.getSimpleName()){
            case "Mocca" :
                return new Mocca();
            case "Latte" :
                return new Latte();
            default:
                return new Latte();
        }
    }
}

class BeerFactory extends AbstractFactorys{
    @Override
    public Product getProduct(Class clazz) {
        switch (clazz.getSimpleName()){
            case "Hans" :
                return new Hans();
            case "Yanjing" :
                return new Yanjing();
            default:
                return new Yanjing();
        }
    }
}

class Hans implements Product{
    @Override
    public int getPrice() {
        return 30;
    }
}

class Yanjing implements Product{
    @Override
    public int getPrice() {
        return 40;
    }
}