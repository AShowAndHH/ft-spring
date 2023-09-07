package com.ft.spring.f1_初识Spring_完整配置;

import com.ft.spring.f1_初识Spring_完整配置.service.SpringService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/9/28 12:17
 */

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_f1_初识Spring_完整配置.xml"})
public class Spring_Complete_Test {
    @Autowired
    private SpringService service;

    @Test
    public void test() {
        log.info("{}", service.select());
    }
}
