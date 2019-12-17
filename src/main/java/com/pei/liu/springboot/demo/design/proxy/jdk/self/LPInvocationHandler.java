package com.pei.liu.springboot.demo.design.proxy.jdk.self;

import java.lang.reflect.Method;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-08 20:08
 * @version: 1.0$
 */
public interface LPInvocationHandler {

    public Object invoke(Object lpproxy, Method method, Object[] args)
            throws Throwable;
}
