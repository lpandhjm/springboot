package com.pei.liu.springboot.demo.design.factory.simplefactory;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-13 21:58
 * @version: 1.0$
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();

        Car car = simpleFactory.getCar("BWM");

        System.out.println(car.getBrand());
    }
}
