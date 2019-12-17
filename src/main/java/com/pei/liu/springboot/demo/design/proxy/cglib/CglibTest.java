package com.pei.liu.springboot.demo.design.proxy.cglib;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-13 20:39
 * @version: 1.0$
 */
public class CglibTest {

    public static void main(String[] args) {

        LiSi liSi = (LiSi) new YellowBull2().getInstance(LiSi.class);
        liSi.buyTrainTickets();
    }
}
