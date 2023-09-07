package com.ft.spring.f5_AOP.jdk_proxy;

import com.ft.spring.f5_AOP.jdk_proxy.bean.JdkBeanInterface;
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
@ContextConfiguration(locations = {"classpath:applicationContext_f5_AOP_JdkProxy.xml"})
public class JdkProxy_Test {
    @Autowired
    private JdkBeanInterface jdkBean;

    @Autowired
    private JdkBeanInterface jdkProxyBean;

    @Test
    public void test(){
        log.info("被代理类：{}", jdkBean.getClass());
        jdkBean.functionA();

        log.info("");

        log.info("代理类：{}", jdkProxyBean.getClass());
        jdkProxyBean.functionA();
    }
}
