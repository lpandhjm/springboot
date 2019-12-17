package com.pei.liu.springboot.demo.design.factory.abstr;

import com.pei.liu.springboot.demo.design.factory.simplefactory.Car;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-13 22:32
 * @version: 1.0$
 */
public abstract class AbstracFactory {

    abstract  Car getCar();

    public Car getCar(String name) {
        if ("bwm".equalsIgnoreCase(name)) {
            return new BwmFactory().getCar();
        } else if ("audi".equalsIgnoreCase(name)) {
            return  new AudiFactory().getCar();
        } else {
            return  null;
        }
    }
}
