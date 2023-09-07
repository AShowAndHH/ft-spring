package com.ft.spring.f6_自定义注解.dynamic_datasource.annotation;

/**
 * @Description: 数据源 id 字典
 * @Author: fangt
 * @CreateTime: 2021/7/12 20:30
 */
public enum DataSourceEnum {
    DATASOURCE_MYSQL_01("DATASOURCE-MYSQL-01"),
    DATASOURCE_MYSQL_02("DATASOURCE-MYSQL-02");

    private String value;

    DataSourceEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
