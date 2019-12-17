package com.pei.liu.springboot.demo.spring.ioc;


import org.junit.Test;

/**
 * @description：ioc测试
 * @author：liupei
 * @create: 2019-12-07 19:24
 * @version: 1.0$
 */
public class SimpleIocTest {

    @Test
    public void getBean() throws Exception {
        String location = "/Users/liupei/Desktop/privateProject/springboot/src/main/java/com/pei/liu/springboot/demo/spring/ioc/ioc.xml";
        SimpleIoc bf = new SimpleIoc(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);
    }
}
