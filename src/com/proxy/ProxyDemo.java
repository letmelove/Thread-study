package com.proxy;

/**
 * 模拟静态代理
 * 代理对象和真实对象要实现同一接口
 * 代理对象要代理真实对象
 */
public class ProxyDemo {
    public static void main(String[] args) {
        new dealer(new me()).drive();
    }

}

//真实对象
class me implements car {
    @Override
    public void drive() {
        System.out.println("我开车");
    }
}

//代理对象
class dealer implements car {
    //代理真实对象
    private car car;
    public dealer(car car) {
        this.car = car;
    }

    @Override
    public void drive() {
        first();
        last();
        this.car.drive();  //这里就是真实对象
    }


    private void first() {
        System.out.println("制作车辆");
    }

    private void last() {
        System.out.println("把车辆送到我手中");
    }

}

interface car {
    public void drive();
}