package com.pei.liu.springboot.demo;

/**
 * @program: springboot
 * @description
 * @author: pei.liu
 * @create: 2019-11-30 22:39
 **/
public class GcTest {

    public static void main(String[] args) {
        byte[] allocation1, allocation2,allocation3,allocation4,allocation5;
        allocation1 = new byte[59920*1024];
        allocation2 = new byte[1900*1024];
        allocation3 = new byte[1000*1024];
        allocation4 = new byte[1000*1024];
        allocation5 = new byte[1000*1024];
    }
}
