package com.pei.liu.springboot.demo.design.singleton;

/**
 * @program: demo
 * @description 单例模式
 * @author: pei.liu
 * @create: 2019-11-29 13:59
 **/
public class Singleton {

    //饿汉式

//    private static Singleton singleton =new Singleton();
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        return  singleton;
//    }

    //懒汉式

//    private static  Singleton singleton;
//
//    private Singleton() {
//
//    }
//
//    public static Singleton getInstance() {
//        if (singleton == null) {
//            singleton =new Singleton();
//        }
//        return singleton;
//    }

    private  static volatile Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            //如果为null 初始化，先给Singleton类对象 上锁
            synchronized (Singleton.class) {
                //这里再加if判断是防止多线程 创建多实例
                if (singleton == null) {
                    singleton =new Singleton();
                }
            }
        }
        return  singleton;
    }

}

