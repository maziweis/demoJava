package com.example.demo.DesignMode;

public class EasyFactory {
    public static Product createProduct(Class clazz){
        switch (clazz.getSimpleName()){
            case "Mocca" :
                return new Mocca();
            case "Latte" :
                return new Latte();
            default:
                return new Latte();
        }
    }

    public static void main(String[] args) {
        Product product = EasyFactory.createProduct(Mocca.class);
        System.out.println(product.getPrice());
    }
}

interface Product{
    int getPrice();
}

class Mocca implements Product{
    @Override
    public int getPrice() {
        return 10;
    }
}

class Latte implements Product{
    @Override
    public int getPrice() {
        return 20;
    }
}