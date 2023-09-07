package com.ft.spring.f5_AOP.spring_aop.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/11/2 12:41
 */
@Slf4j
@Aspect
@Component
public class LoggingAspect {
    /**
     * 定义切点
     */
    @Pointcut("execution(* com.ft.spring.f5_AOP.*_proxy.bean.*Bean.function*(..))")
    public void pointcut01(){}

    /**
     * 定义切点(带参数)
     */
    @Pointcut("execution(* com.ft.spring.f5_AOP.*_proxy.bean.*Bean.function*(String, ..)) && args(param01)")
    public void pointcut02(String param01){}

    @Around("pointcut01()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("{} 环绕通知-前（@Around）", joinPoint.getSignature().getName());
        joinPoint.proceed();
        log.info("{} 环绕通知-后（@Around）", joinPoint.getSignature().getName());
        return null;
    }

    @Before("pointcut01()")
    public void before(JoinPoint joinPoint){
        log.info("{} 前置通知（@Before）", joinPoint.getSignature().getName());
    }

    @After("pointcut01()")
    public void after(JoinPoint joinPoint){
        log.info("{} 后置通知（@After）", joinPoint.getSignature().getName());
    }

    @AfterReturning("pointcut01()")
    public void afterReturning(JoinPoint joinPoint){
        log.info("{} 返回通知（@AfterReturning）", joinPoint.getSignature().getName());
    }

    @AfterThrowing("pointcut01()")
    public void afterThrowing(JoinPoint joinPoint){
        log.info("{} 异常通知（@AfterThrowing）", joinPoint.getSignature().getName());
    }
}
