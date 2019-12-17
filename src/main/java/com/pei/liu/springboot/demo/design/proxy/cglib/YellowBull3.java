package com.pei.liu.springboot.demo.design.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-13 21:22
 * @version: 1.0$
 */
public class YellowBull3 implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("另一个黄牛帮你买票");
        methodProxy.invokeSuper(o, objects);
        return null;
    }
}
