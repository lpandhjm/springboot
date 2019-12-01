package com.pei.liu.springboot.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    @Pointcut("@annotation(com.pei.liu.springboot.annotation.AnnotationTest)")
    public void testPointCut() {

    }

    @Before("testPointCut()")
    public void testBefore(){
        System.out.println("----------before");
    }

    @After("testPointCut()")
    public void testAfter(){
        System.out.println("----------after");
    }
}
