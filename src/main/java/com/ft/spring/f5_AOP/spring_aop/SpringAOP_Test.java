package com.ft.spring.f5_AOP.spring_aop;

import com.ft.spring.f5_AOP.cglib_proxy.bean.CglibBean;
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
@ContextConfiguration(locations = {"classpath:applicationContext_f5_AOP_SpringAOP.xml"})
public class SpringAOP_Test {
    @Autowired
    private CglibBean cglibProxyBean;

    @Autowired
    private JdkBeanInterface jdkProxyBean;

    @Test
    public void test(){
        log.info("代理类：{}", cglibProxyBean.getClass());
        cglibProxyBean.functionA();

        log.info("");

        log.info("代理类：{}", jdkProxyBean.getClass());
        jdkProxyBean.functionA();
    }
}
