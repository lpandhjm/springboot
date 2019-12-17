package com.pei.liu.springboot.demo.design.factory.abstr;

import com.pei.liu.springboot.demo.design.factory.factoryfunc.Factory;
import com.pei.liu.springboot.demo.design.factory.simplefactory.Bmw;
import com.pei.liu.springboot.demo.design.factory.simplefactory.Car;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-13 22:23
 * @version: 1.0$
 */
public class BwmFactory extends   AbstracFactory {
    @Override
    public Car getCar() {
        System.out.println("产宝马");
        return new Bmw();

    }
}
