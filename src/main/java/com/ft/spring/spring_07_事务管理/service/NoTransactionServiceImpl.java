package com.ft.spring.spring_07_事务管理.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/26 9:32
 */
@Service
@Order(1)
public class NoTransactionServiceImpl implements InsertService{
    @Autowired
    private CURDService curdService;

    @Override
    public void insert() {
        // 执行数据库操作
        curdService.insert("NO-Transaction", "无事务控制");
    }
}
