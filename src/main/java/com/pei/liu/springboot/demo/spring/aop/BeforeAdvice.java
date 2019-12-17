package com.pei.liu.springboot.demo.spring.aop;

import java.lang.reflect.Method;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-07 19:40
 * @version: 1.0$
 */
public class BeforeAdvice implements Advice {

    private Object bean;
    private MethodInvocation methodInvocation;

    public BeforeAdvice(Object bean, MethodInvocation methodInvocation) {
        this.bean = bean;
        this.methodInvocation = methodInvocation;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行目标方法前调用通知
        methodInvocation.invoke();
        return method.invoke(bean,args);
    }
}
