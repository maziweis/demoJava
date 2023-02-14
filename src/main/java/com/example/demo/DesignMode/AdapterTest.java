package com.example.demo.DesignMode;

//适配器模式：将一个类的接口变成客户端所期望的另一种接口，从而使原本因接口不匹配而无法一起工作的两个类能够在一起工作
public class AdapterTest {
    public static void main(String[] args) {
        TypeC typeC = new TypeC();
        AdapterMicroUSB adapterMicroUSB = new AdapterMicroUSB(typeC);
        adapterMicroUSB.charger();
    }
}

interface IMicroUSB{
    void charger();
}
interface ITypeC{
    void charger();
}

class TypeC implements ITypeC{
    @Override
    public void charger() {
        System.out.println("typeC冲电");
    }
}

class AdapterMicroUSB implements IMicroUSB{
    private TypeC typeC;

    public AdapterMicroUSB(TypeC typeC){
        this.typeC = typeC;
    }

    @Override
    public void charger() {
        typeC.charger();
    }
}



