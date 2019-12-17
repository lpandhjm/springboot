package com.pei.liu.springboot.demo.design.factory.factoryfunc;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-13 22:26
 * @version: 1.0$
 */
public class FactoryTest {
    public static void main(String[] args) {
        Factory factory = new AudiFactory();
        System.out.println(factory.getCar().getBrand());

        factory = new BwmFactory();
        System.out.println(factory.getCar().getBrand());
    }
}
