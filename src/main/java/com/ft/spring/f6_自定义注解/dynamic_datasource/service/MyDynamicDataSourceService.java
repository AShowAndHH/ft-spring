package com.ft.spring.f6_自定义注解.dynamic_datasource.service;

import com.ft.spring.f6_自定义注解.dynamic_datasource.annotation.DataSourceEnum;
import com.ft.spring.f6_自定义注解.dynamic_datasource.annotation.MyDynamicDataSource;
import com.ft.spring.f6_自定义注解.dynamic_datasource.dao.Mysql01Mapper;
import com.ft.spring.f6_自定义注解.dynamic_datasource.dao.Mysql02Mapper;
import com.ft.spring.f6_自定义注解.dynamic_datasource.dto.Mysql01DO;
import com.ft.spring.f6_自定义注解.dynamic_datasource.dto.Mysql02DO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: fangt
 * @CreateTime: 2022/2/16 10:01
 */
@Slf4j
@Service
public class MyDynamicDataSourceService {
    @Autowired
    private Mysql01Mapper mysql01Mapper;
    @Autowired
    private Mysql02Mapper mysql02Mapper;

    /**
     * 查询【DATASOURCE_MYSQL_01】
     */
    public void selectFromMysql01(){
        try {
            List<Mysql01DO> selectList = mysql01Mapper.selectList(null);
            log.info("查询【DATASOURCE_MYSQL_01】成功：{}", selectList);
        }catch (Exception e){
            log.error("查询【DATASOURCE_MYSQL_01】异常", e);
        }
    }

    /**
     * 查询【DATASOURCE_MYSQL_02】
     */
    public void selectFromMysql02(){
        try {
            List<Mysql02DO> selectList = mysql02Mapper.selectList(null);
            log.info("查询【DATASOURCE_MYSQL_02】成功：{}", selectList);
        }catch (Exception e){
            log.error("查询【DATASOURCE_MYSQL_02】异常", e);
        }
    }

    /**
     * 查询【DATASOURCE_MYSQL_02】，使用注解动态切换数据源
     */
    @MyDynamicDataSource(DataSourceEnum.DATASOURCE_MYSQL_02)
    public void selectFromMysql02WithAnnotation(){
        selectFromMysql02();
    }
}
