package com.ft.spring.spring_07_事务管理.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/26 9:32
 */
@Service
@Order(2)
public class TransactionManagerServiceImpl implements InsertService{
    @Autowired
    private CURDService curdService;
    @Autowired
    @Qualifier("dataSourceTransactionManager")
    private PlatformTransactionManager transactionManager;

    @Override
    public void insert() {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        try{
            // 执行数据库操作
            curdService.insert("TransactionManager", "编程式事务-基于底层API");

            // 事务提交
            transactionManager.commit(status);
        }catch (Exception e){
            // 事务回滚
            transactionManager.rollback(status);
        }
    }
}
