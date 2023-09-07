package com.ft.spring.f6_自定义注解.dynamic_datasource.annotation;

import java.lang.annotation.*;

/**
 * @Description: 切换数据源注解
 * @Author: fangt
 * @CreateTime: 2021/7/12 17:48
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyDynamicDataSource {
    /**
     * 数据源
     */
    DataSourceEnum value();
}
