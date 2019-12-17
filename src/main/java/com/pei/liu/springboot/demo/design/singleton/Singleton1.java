package com.pei.liu.springboot.demo.design.singleton;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-13 23:16
 * @version: 1.0$
 */
public class Singleton1 {

    private Singleton1(){

        System.out.println("第一次");
    }

    private  static  class  LazyLoad{

        private  static  final Singleton1  singleton1 =new Singleton1();
    }

    private  static  final  Singleton1 getInstance(){

        return  LazyLoad.singleton1;
    }
}
