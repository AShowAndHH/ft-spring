package com.ft.spring.spring_05_AOP;

import com.ft.spring.spring_05_AOP.common.JdkBeanInterface;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/28 12:12
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_05_AOP_JdkProxy.xml"})
public class JdkProxy_Test {
    @Autowired
    private JdkBeanInterface jdkProxyBean;

    @Test
    public void test(){
        log.info("---------- 执行 {} ----------", jdkProxyBean.getClass());
        jdkProxyBean.exe_a();
    }
}
