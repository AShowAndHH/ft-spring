package com.ft.spring.f7_事务管理.service.impl;

import com.ft.spring.f7_事务管理.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/26 9:32
 */
@Service
@Order(3)
public class Insert03TransactionTemplateServiceImpl extends InsertService {
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void insert() {
        // 方式一：显示捕获异常，显示事务回滚
        Object o = transactionTemplate.execute((TransactionCallback) status -> {
            try {
                // 执行数据库操作
                insert("03", "编程式-基于事务模板（TransactionTemplate）-方式1");
            } catch (Exception e) {
                // 事务回滚
                status.setRollbackOnly();
            }
            return null;
        });

        // 方式二：抛出异常，自动事务回滚
        Object o2 = transactionTemplate.execute((TransactionCallback) status -> {
            // 执行数据库操作
            insert("03", "编程式-基于事务模板（TransactionTemplate）-方式2");
            return null;
        });
    }
}
