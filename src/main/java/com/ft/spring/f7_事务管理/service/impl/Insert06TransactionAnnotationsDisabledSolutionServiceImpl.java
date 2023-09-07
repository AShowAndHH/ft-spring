package com.ft.spring.f7_事务管理.service.impl;

import com.ft.spring.f7_事务管理.service.InsertService;
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
@Order(6)
public class Insert06TransactionAnnotationsDisabledSolutionServiceImpl extends InsertService {
    @Autowired
    private Insert06TransactionAnnotationsDisabledSolutionServiceImpl solutionService;

    @Override
    public void insert() {
        solutionService.insert2();
    }

    /**
     * 解决方案：注入自身 Bean，等效于对象间方法调用，会触发AOP
     */
    @Transactional(rollbackFor = Exception.class)
    public void insert2() {
        // 执行数据库操作
        insert("06", "声明式事务-基于注解（@Transactional）-同对象方法间调用，注解失效-解决方法");
    }
}
