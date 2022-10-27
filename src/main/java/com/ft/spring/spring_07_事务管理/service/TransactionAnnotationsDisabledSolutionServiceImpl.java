package com.ft.spring.spring_07_事务管理.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/26 9:32
 */
@Service
@Order(6)
public class TransactionAnnotationsDisabledSolutionServiceImpl implements InsertService{
    @Autowired
    private CURDService curdService;

    @Autowired
    @Qualifier("transactionAnnotationsDisabledSolutionServiceImpl")
    private InsertService thisBean;

    @Override
    public void insert() {
        thisBean.transaction_insert();
    }

    /**
     * 注解失效1-解决方案：注入自身 Bean，等效于对象间方法调用，会触发AOP
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transaction_insert(){
        // 执行数据库操作
        curdService.insert("@Transactional", "声明式事务-基于注解（注解失效1-解决方案）");
    }
}
