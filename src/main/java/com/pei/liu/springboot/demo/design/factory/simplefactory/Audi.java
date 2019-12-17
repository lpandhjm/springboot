package com.pei.liu.springboot.demo.design.factory.simplefactory;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-13 21:56
 * @version: 1.0$
 */
public class Audi implements Car {
    @Override
    public String getBrand() {
        return "奥迪车";
    }
}
