package com.pei.liu.springboot.demo.design.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-13 20:34
 * @version: 1.0$
 */
public class YellowBull2 implements MethodInterceptor {





    public Object getInstance(Class c) {
        Enhancer enhancer =new Enhancer();

//        cglib生成的子类的父类是c
        enhancer.setSuperclass(c);

        enhancer.setCallback(new YellowBull3());

        /**
         * 生成源代码
         * 编译成class文件
         * 加载到jvm
         */
        return enhancer.create();
    }

    //    原理也是字节码重组，对比jdk少写了接口
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("黄牛帮你买票");
//        o 是CGLib给我们new出来的
//        cglibnew出来的对象 是被代理对象的子类
//        oop 在new 子类之前，先调用了super（）方法
//        
        methodProxy.invokeSuper(o,objects);
        System.out.println("买好了！");
        return null;
    }
}
