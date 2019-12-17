package com.pei.liu.springboot.demo.design.factory.factoryfunc;

import com.pei.liu.springboot.demo.design.factory.simplefactory.Audi;
import com.pei.liu.springboot.demo.design.factory.simplefactory.Car;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-13 22:23
 * @version: 1.0$
 */
public class AudiFactory implements  Factory {
    @Override
    public Car getCar() {
        return new Audi();
    }
}
