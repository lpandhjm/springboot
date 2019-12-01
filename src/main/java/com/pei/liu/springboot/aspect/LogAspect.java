package com.pei.liu.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private Logger logger= LoggerFactory.getLogger(getClass());
    @Pointcut("@annotation(com.pei.liu.springboot.annotation.LogAnnotation)")
    public void logPointCut(){}

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 调用方法的参数
        Object[] args = point.getArgs();
        // 调用的方法名
        String method = point.getSignature().getName();
        // 获取目标对象
        Object target = point.getTarget().getClass().getName();
        logger.info("方法参数{},方法名{}，目标对象{}",args,method,target);
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        logger.info("执行时长{}",time);
        return result;
    }
}
