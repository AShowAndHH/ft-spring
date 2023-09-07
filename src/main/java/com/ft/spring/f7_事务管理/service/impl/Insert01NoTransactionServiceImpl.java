package com.ft.spring.f7_事务管理.service.impl;

import com.ft.spring.f7_事务管理.service.InsertService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/26 9:32
 */
@Service
@Order(1)
public class Insert01NoTransactionServiceImpl extends InsertService {
    @Override
    public void insert() {
        insert("01", "不进行事务控制（No Transaction）");
    }
}
