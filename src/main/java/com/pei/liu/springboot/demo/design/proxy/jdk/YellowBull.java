package com.pei.liu.springboot.demo.design.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description：黄牛帮你干事情
 * @author：liupei
 * @create: 2019-12-08 15:06
 * @version: 1.0$
 */
public class YellowBull implements InvocationHandler {


    private Object target;


    public Object getInstance(Person person) {
        this.target = person;
//         Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) 方法三个参数
//        1，ClassLoader loader 代理对象使用哪个类装载器
//        2，Class<?>[] interfaces 生成哪个对象的代理对象。通过接口指定
//        3，InvocationHandler h  调用处理器; 调用实现了InvocationHandler 类的一个回调方法
        return Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), this);
    }


//    Object invoke(Object proxy, Method method, Object[] args) throws Throwable
//    三个参数的意思：
//    Object proxy    proxy是指方法被调用的代理实例，（这里就是target）
//    Method method   是我们所要调用真实对象的某个方法的Method对象（）
//    Object[] args   args 的是调用真实对象某个方法时接受的参数（这里是 name 和idCard）

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("黄牛帮你买票");
        method.invoke(target, args);
        System.out.println("买好了！");
        return null;
    }

}
