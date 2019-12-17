package com.pei.liu.springboot.demo.design.factory.simplefactory;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-13 21:55
 * @version: 1.0$
 */
public class Bmw implements  Car {
    @Override
    public String getBrand() {
        return "宝马车";
    }
}
