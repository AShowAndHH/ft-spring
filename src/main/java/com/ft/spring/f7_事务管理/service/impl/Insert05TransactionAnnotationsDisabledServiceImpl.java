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
@Order(5)
public class Insert05TransactionAnnotationsDisabledServiceImpl extends InsertService {
    @Override
    public void insert() {
        insert2();
    }

    /**
     * 同对象方法间调用，@Transactional 注解失效
     */
    @Transactional(rollbackFor = Exception.class)
    public void insert2() {
        // 执行数据库操作
        insert("05", "声明式事务-基于注解（@Transactional）-同对象方法间调用，注解失效");
    }
}
