package com.pei.liu.springboot.demo.spring.aop;

import java.lang.reflect.Proxy;

/**
 * @description：简单aop
 * @author：liupei
 * @create: 2019-12-07 19:36
 * @version: 1.0$
 */
public class  SimpleAop {

    public static Object getProxy(Object bean,Advice advice) {
//         newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) 方法三个参数
//        1，ClassLoader loader 指明代理对象使用哪个类装载器
//        2，Class<?>[] interfaces 指明生成哪个对象的代理对象。通过接口指定
//        3，InvocationHandler h  调用处理器; 调用实现了InvocationHandler 类的一个回调方法
        return Proxy.newProxyInstance(SimpleAop.class.getClassLoader(),bean.getClass().getInterfaces(),advice);
    }

}
