package com.pei.liu.springboot.demo.design.proxy.jdk.self;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-08 21:00
 * @version: 1.0$
 */
public class LPProxyTest {

    public static void main(String[] args)  throws  Exception{
        LPYellowBull LPyellowBull = new LPYellowBull();
        LPPerson person = (LPPerson) LPyellowBull.getInstance(new LPZhangShan());
        person.BuyTrainTickets();
//        jdk动态代理原理：
//        jdk从新生成了一个类，并且实现了代理对象的所实现的接口，动态生成了一个class字节码
//        我们看下生成的class字节码是怎样的
//        String filePath = "/Users/liupei/Desktop/privateProject/springboot/src/main/java/com/pei/liu/springboot/demo/design/proxy/jdk/self/";
//        byte[] data = ProxyGenerator.generateProxyClass("$proxy0",new Class[]{person.getClass()});
//        FileOutputStream fileOutputStream =new FileOutputStream(filePath+"$Proxy.class");
//        fileOutputStream.write(data);
//        fileOutputStream.close();
//        System.out.println(person.getClass());
//        person.BuyTrainTickets("张三","362426199303263511");
//
    }
}
