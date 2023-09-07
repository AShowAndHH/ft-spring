package com.ft.spring.f7_事务管理.service;

import com.ft.spring.f7_事务管理.dao.TransactionMapper;
import com.ft.spring.f7_事务管理.dto.TransactionDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/26 19:02
 */
@Slf4j
@Service
public abstract class InsertService {
    @Autowired
    private TransactionMapper transactionMapper;

    /**
     * 插入数据
     */
    public abstract void insert();

    protected void insert(String code, String info) {
        log.info("开始 insert(code=[{}],name=[{}])", code, info);
        transactionMapper.insert(new TransactionDO(code, info));
        // 抛出异常，用于验证 insert 是否回滚
        int a = 1/0;
    }
}
