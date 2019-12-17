package com.pei.liu.springboot.demo.spring.aop;

import org.junit.Test;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-07 20:31
 * @version: 1.0$
 */
public class SimpleAopTest {

    @Test
    public void getProxy() {


        // 1. 创建一个 MethodInvocation 实现类
        MethodInvocation methodInvocation =() -> System.out.println("log task start");
        HelloServiceImpl helloServiceimpl =new HelloServiceImpl();
        // 2. 创建一个 Advice
        Advice beforeAdvice =new BeforeAdvice(helloServiceimpl,methodInvocation);

        // 3. 为目标对象生成代理
        HelloService helloServiceimplProxy = (HelloService) SimpleAop.getProxy(helloServiceimpl,beforeAdvice);

        helloServiceimplProxy.sayHelloWorld();

    }
}
