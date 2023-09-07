package com.ft.spring.f4_Bean_LifeCycle;

import com.ft.spring.f4_Bean_LifeCycle.bean.AbstractLifeCycleBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/13 13:57
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_f4_Bean_LifeCycle.xml"})
public class Bean_LifeCycle_Test {
    @Autowired
    private List<AbstractLifeCycleBean> beans;

    @Test
    public void test(){
        log.info("{}", beans);
    }
}
