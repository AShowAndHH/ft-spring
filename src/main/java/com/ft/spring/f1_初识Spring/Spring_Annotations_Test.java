package com.ft.spring.f1_初识Spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description 读取 Spring 配置文件（注解读取）
 *      RunWith注解：使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
 *      ContextConfiguration注解：加载配置文件
 * @Author fangt
 * @CreateTime 2022/9/28 12:17
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_f1_初识Spring.xml"})
public class Spring_Annotations_Test {
    @Autowired
    private SpringBean bean;

    @Test
    public void test() {
        log.info("{}", bean);
    }
}
