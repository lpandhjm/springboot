package com.pei.liu.springboot.demo.design.proxy.jdk;

import org.omg.PortableInterceptor.DISCARDING;

/**
 * @description：一个人叫张三的人
 * @author：liupei
 * @create: 2019-12-08 15:02
 * @version: 1.0$
 */
public class ZhangShan implements Person{

    private  String name ;

    private String IDCard;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void BuyTrainTickets(String name, String IDCard) {
        this.name = name;
        this.IDCard=IDCard;
        System.out.println("提供姓名身份证-----"+name+"："+IDCard);
    }



}
