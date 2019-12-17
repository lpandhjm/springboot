package com.pei.liu.springboot.demo.design.factory.simplefactory;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-13 21:57
 * @version: 1.0$
 */
public class SimpleFactory {

    public Car getCar(String name) {
//        工长自己玩
        if ("bwm".equalsIgnoreCase(name)) {
            return new Bmw();
        } else if ("audi".equalsIgnoreCase(name)) {
            return  new Audi();
        } else {
            return  null;
        }
    }
}
