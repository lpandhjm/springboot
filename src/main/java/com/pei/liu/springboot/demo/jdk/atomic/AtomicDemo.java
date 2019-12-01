package com.pei.liu.springboot.demo.jdk.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: springboot
 * @description
 * @author: pei.liu
 * @create: 2019-11-30 15:22
 **/
public class AtomicDemo {

//    基本类型原子类：
//    1.AtomicInteger 2.AtomicLon 3.AtomicBoole

//    AtomicInteger使用方法

    public static void main(String[] args) {

    }

   static class AtomicIntegerDemo{
        public static void main(String[] args) {
            int i=1;
            AtomicInteger atomicInteger =new AtomicInteger(i);
//            获取当前值
            System.out.println(atomicInteger.get());
//            获取当前值并设置新的值
            System.out.println("当前值：" + atomicInteger.getAndSet(2) + "新值：" + atomicInteger.get());
//            获取当前值并自增
            atomicInteger.getAndIncrement();
            System.out.println(atomicInteger.get());
//            获取当前值并自减
            atomicInteger.getAndDecrement();
            System.out.println(atomicInteger.get());
//            获取当前值并加上预期值
            atomicInteger.getAndAdd(5);
            System.out.println(atomicInteger.get());
//            如果输入的数值等于预期值，则以原子方式将该值设置为输入值
            atomicInteger.compareAndSet(7,9);
            System.out.println(atomicInteger.get());
        }
    }
}
