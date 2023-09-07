package com.ft.spring.f6_自定义注解.dynamic_datasource.config;

import com.ft.spring.f6_自定义注解.dynamic_datasource.annotation.DataSourceEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataSourceConfigHolder {
    /**
     * 线程内存对象
     */
    private static final ThreadLocal<String> DATASOURCE_CONFIG_HOLDER = new ThreadLocal<>();

    public static String getDataSource() {
//        String dataSource = Optional.ofNullable(DATASOURCE_CONFIG_HOLDER.get()).orElse("默认");
//        log.info("========== 使用数据源【{}】", dataSource);
        return DATASOURCE_CONFIG_HOLDER.get();
    }

    public static void setDataSource(DataSourceEnum dataSource) {
//        log.info("========== 切换数据源【{}】", dataSource.getValue());
        DATASOURCE_CONFIG_HOLDER.set(dataSource.getValue());
    }

    public static void removeDataSource() {
//        log.info("========== 清除数据源【{}】", DATASOURCE_CONFIG_HOLDER.get());
        DATASOURCE_CONFIG_HOLDER.remove();
    }
}

