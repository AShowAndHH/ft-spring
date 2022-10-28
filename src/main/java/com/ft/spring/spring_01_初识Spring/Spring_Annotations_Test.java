package com.ft.spring.spring_01_初识Spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description 读取 Spring 配置文件（注解读取）
 * @Author fangt
 * @CreateTime 2022/9/28 12:17
 */

@Slf4j
// 使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
// 加载配置文件，否则无法注入
@ContextConfiguration(locations = {"classpath:applicationContext_01_初识Spring.xml"})
public class Spring_Annotations_Test {
    @Autowired
    private SpringBean bean;

    @Test
    public void test() {
        log.info("{}", bean);
    }
}
