package com.ft.spring.spring_07_事务管理.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/26 9:32
 */
@Service
@Order(4)
public class TransactionAnnotationsServiceImpl implements InsertService{
    @Autowired
    private CURDService curdService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert() {
        // 执行数据库操作
        curdService.insert("@Transactional", "声明式事务-基于注解");
    }
}
