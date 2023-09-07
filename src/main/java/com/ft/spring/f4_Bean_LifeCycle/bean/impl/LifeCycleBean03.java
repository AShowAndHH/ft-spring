package com.ft.spring.f4_Bean_LifeCycle.bean.impl;

import com.ft.spring.f4_Bean_LifeCycle.bean.AbstractLifeCycleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2023/8/15 14:00
 */
@Component
public class LifeCycleBean03 extends AbstractLifeCycleBean {
    @Autowired
    private LifeCycleBean01 lifeCycleBean01;
}
