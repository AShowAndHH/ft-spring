package com.ft.spring.f6_自定义注解.task_log.annotation;

import java.lang.annotation.*;

/**
 * @Description: 任务日志注解
 * @Author: fangt
 * @CreateTime: 2021/7/12 16:29
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTaskLog {
    /**
     * 任务名称
     */
    String value() default "";
}
