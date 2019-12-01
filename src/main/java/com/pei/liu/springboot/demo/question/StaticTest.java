package com.pei.liu.springboot.demo.question;

/**
 * @program: demo
 * @description Static 测试
 * @author: pei.liu
 * @create: 2019-11-28 15:54
 **/


public class StaticTest {

    static {
        System.out.println("父类静态代码块");
    }
    {
        System.out.println("父类非静态代码块");
    }

    public StaticTest() {
        System.out.println("父类构造方法");
    }

    public static void main(String[] args) {
        new StaticTest();
    }
}
