package com.pei.liu.springboot.demo.design.proxy.jdk.self;

import java.lang.reflect.Method;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-08 20:08
 * @version: 1.0$
 */
public class LPYellowBull implements  LPInvocationHandler {
    private Object target;


    public Object getInstance(LPPerson person) {
        this.target = person;
//         Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) 方法三个参数
//        1，ClassLoader loader 代理对象使用哪个类装载器
//        2，Class<?>[] interfaces 生成哪个对象的代理对象。通过接口指定
//        3，InvocationHandler h  调用处理器; 调用实现了InvocationHandler 类的一个回调方法
        return LPProxy.newProxyInstance(new LPClassLoader(), person.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object lpproxy, Method method, Object[] args) throws Throwable {
        System.out.println("黄牛帮你买票");
        method.invoke(target, args);
        System.out.println("买好了！");
        return null;
    }
}
