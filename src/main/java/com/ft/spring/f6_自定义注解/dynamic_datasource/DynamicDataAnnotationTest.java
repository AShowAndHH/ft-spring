package com.ft.spring.f6_自定义注解.dynamic_datasource;

import com.ft.spring.f6_自定义注解.dynamic_datasource.annotation.DataSourceEnum;
import com.ft.spring.f6_自定义注解.dynamic_datasource.annotation.MyDynamicDataSource;
import com.ft.spring.f6_自定义注解.dynamic_datasource.config.DataSourceConfigHolder;
import com.ft.spring.f6_自定义注解.dynamic_datasource.config.MyDynamicDataSourceAop;
import com.ft.spring.f6_自定义注解.dynamic_datasource.service.MyDynamicDataSourceService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description: 自定义注解 测试
 * @Author: fangt
 * @CreateTime: 2021/7/12 14:21
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_f6_自定义注解_DynamicDataSource.xml"})
public class DynamicDataAnnotationTest {
    @Autowired
    private MyDynamicDataSourceService myDynamicDataSourceService;

    /**
     * 多数据源-手动切换数据源
     */
    @Test
    public void test1(){
        log.info("-------------------- 多数据源 手动切换数据源 --------------------");
        log.info("（1）查询【DATASOURCE_MYSQL_01】");
        myDynamicDataSourceService.selectFromMysql01();
        log.info("（2）查询【DATASOURCE_MYSQL_02】");
        try{
            DataSourceConfigHolder.setDataSource(DataSourceEnum.DATASOURCE_MYSQL_02);
            myDynamicDataSourceService.selectFromMysql02();
        }finally {
            DataSourceConfigHolder.removeDataSource();
        }
        log.info("（3）查询【DATASOURCE_MYSQL_01】");
        myDynamicDataSourceService.selectFromMysql01();
    }

    /**
     * 多数据源-动态切换数据源
     * 使用自定义注解：{@link MyDynamicDataSource}、{@link MyDynamicDataSourceAop}
     */
    @Test
    public void test2(){
        log.info("-------------------- 多数据源 动态切换数据源 --------------------");
        log.info("（1）查询【DATASOURCE_MYSQL_01】");
        myDynamicDataSourceService.selectFromMysql01();
        log.info("（2）查询【DATASOURCE_MYSQL_02】");
        myDynamicDataSourceService.selectFromMysql02WithAnnotation();
        log.info("（3）查询【DATASOURCE_MYSQL_01】");
        myDynamicDataSourceService.selectFromMysql01();
    }
}
