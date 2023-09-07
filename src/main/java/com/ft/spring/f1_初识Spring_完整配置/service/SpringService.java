package com.ft.spring.f1_初识Spring_完整配置.service;

import com.ft.spring.f1_初识Spring_完整配置.dao.SpringMapper;
import com.ft.spring.f1_初识Spring_完整配置.dto.SpringDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/9/28 13:10
 */
@Service
public class SpringService {
    @Autowired
    private SpringMapper springMapper;

    public SpringDO select(){
        return springMapper.select();
    }
}
