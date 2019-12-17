package com.pei.liu.springboot.demo.spring.aop;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-07 20:30
 * @version: 1.0$
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHelloWorld() {
        System.out.println("hello,word");
    }
}
