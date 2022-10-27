package com.ft.spring.spring_07_事务管理.service;

import com.ft.spring.spring_07_事务管理.dao.TransactionMapper;
import com.ft.spring.spring_07_事务管理.dto.TransactionDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/26 19:02
 */
@Service
@Slf4j
public class CURDService {
    @Autowired
    private TransactionMapper transactionMapper;

    /**
     * 操作数据库时，模拟抛出异常，需要回滚的场景
     */
    public void insert(String code, String name) {
        log.info("insert(code=[{}],name=[{}])", code, name);
        transactionMapper.insert(new TransactionDO(code, name));
        // 抛出异常
        int a = 1/0;
    }
}
