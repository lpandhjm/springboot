package com.pei.liu.springboot.demo.question;

/**
 * @program: demo
 * @description
 * @author: pei.liu
 * @create: 2019-11-28 15:57
 **/
public class StaticTes2  extends StaticTest{
    static {
        System.out.println("子类静态代码块");
    }
    {
        System.out.println("子类非静态代码块");
    }

    public StaticTes2() {
        System.out.println("子类构造方法");
    }

    public static void main(String[] args) {
        new StaticTes2();
    }
}
