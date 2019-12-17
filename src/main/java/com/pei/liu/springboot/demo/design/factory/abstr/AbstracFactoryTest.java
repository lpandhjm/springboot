package com.pei.liu.springboot.demo.design.factory.abstr;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-13 22:36
 * @version: 1.0$
 */
public class AbstracFactoryTest {
    public static void main(String[] args) {

        DefautFactory defautFactory = new DefautFactory();

        defautFactory.getCar();

        defautFactory.getCar("bmw");
    }
}
