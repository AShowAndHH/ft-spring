package com.ft.spring.f6_自定义注解.dynamic_datasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description: 动态数据源
 * @Author: fangt
 * @CreateTime: 2021/7/12 18:00
 */
public class MyDynamicDataSourceRouter extends AbstractRoutingDataSource {
    /**
     * 每次使用数据源的时候，都会先执行此方法，获取到数据源的id，实现动态加载数据源
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceConfigHolder.getDataSource();
    }
}
