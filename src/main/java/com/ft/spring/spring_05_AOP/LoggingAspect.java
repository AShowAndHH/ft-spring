package com.ft.spring.spring_05_AOP;

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
    @Pointcut("execution(* com.ft.spring.spring_05_AOP.service.*.*.exe_*(..))")
    public void pointcut01(){}

    /**
     * 定义切点(带参数)
     */
    @Pointcut("execution(* com.ft.spring.spring_05_AOP.service.*.*.exe_*(String, ..)) && args(param01)")
    public void pointcut02(String param01){}

    @Around("pointcut01()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.debug("{} 环绕通知（@Around）-前", joinPoint.getSignature().getName());
        joinPoint.proceed();
        log.debug("{} 环绕通知（@Around）-后", joinPoint.getSignature().getName());
        return null;
    }

    @Before("pointcut01()")
    public void before(JoinPoint joinPoint){
        log.debug("{} 前置通知（@Before）", joinPoint.getSignature().getName());
    }

    @After("pointcut01()")
    public void after(JoinPoint joinPoint){
        log.debug("{} 后置通知（@After）", joinPoint.getSignature().getName());
    }

    @AfterReturning("pointcut01()")
    public void afterReturning(JoinPoint joinPoint){
        log.debug("{} 返回通知（@AfterReturning）", joinPoint.getSignature().getName());
    }

    @AfterThrowing("pointcut01()")
    public void afterThrowing(JoinPoint joinPoint){
        log.debug("{} 异常通知（@AfterThrowing）", joinPoint.getSignature().getName());
    }
}
