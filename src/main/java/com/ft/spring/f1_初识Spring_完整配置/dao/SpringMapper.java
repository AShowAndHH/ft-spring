package com.ft.spring.f1_初识Spring_完整配置.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ft.spring.f1_初识Spring_完整配置.dto.SpringDO;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/9/28 13:03
 */
public interface SpringMapper extends BaseMapper<SpringDO> {
    SpringDO select();
}
