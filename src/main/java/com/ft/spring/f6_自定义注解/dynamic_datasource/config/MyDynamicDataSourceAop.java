package com.ft.spring.f6_自定义注解.dynamic_datasource.config;

import com.ft.spring.f6_自定义注解.dynamic_datasource.annotation.MyDynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description: Spring AOP
 * @Author: fangt
 * @CreateTime: 2021/7/7 17:11
 */
@Slf4j
@Component
@Order(1)
@Aspect
public class MyDynamicDataSourceAop {
    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.ft.spring.f6_自定义注解.dynamic_datasource.annotation.MyDynamicDataSource)")
    public void pointcut(){ }

    @Around("pointcut() && @annotation(dynamicDataSource)")
    public Object around(ProceedingJoinPoint joinPoint, MyDynamicDataSource dynamicDataSource) throws Throwable {
        Object result;
        try {
            DataSourceConfigHolder.setDataSource(dynamicDataSource.value());
            result = joinPoint.proceed();
        }finally {
            DataSourceConfigHolder.removeDataSource();
        }
        return result;
    }
}
