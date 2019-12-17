package com.pei.liu.springboot.demo.design.proxy.jdk.self;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-08 20:06
 * @version: 1.0$
 */
public class LPZhangShan implements  LPPerson {
    private  String name ="张三";

    private String IDCard="362426199302363511";


    @Override
    public void BuyTrainTickets() {

        System.out.println("提供姓名身份证-----"+name+"："+IDCard);
    }
}
