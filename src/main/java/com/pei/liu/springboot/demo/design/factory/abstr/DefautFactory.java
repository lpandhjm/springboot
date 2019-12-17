package com.pei.liu.springboot.demo.design.factory.abstr;

import com.pei.liu.springboot.demo.design.factory.simplefactory.Car;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-13 22:37
 * @version: 1.0$
 */
public class DefautFactory extends AbstracFactory {

    private AudiFactory factory = new AudiFactory();


    @Override
    Car getCar() {
        return factory.getCar();
    }
}
