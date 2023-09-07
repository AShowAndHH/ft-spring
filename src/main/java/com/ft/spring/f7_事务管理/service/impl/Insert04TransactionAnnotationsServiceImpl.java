package com.ft.spring.f7_事务管理.service.impl;

import com.ft.spring.f7_事务管理.service.InsertService;
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
public class Insert04TransactionAnnotationsServiceImpl extends InsertService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert() {
        // 执行数据库操作
        insert("04", "声明式事务-基于注解（@Transactional）");
    }
}
