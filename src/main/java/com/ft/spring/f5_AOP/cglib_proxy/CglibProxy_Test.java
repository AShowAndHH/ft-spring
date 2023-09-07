package com.ft.spring.f5_AOP.cglib_proxy;

import com.ft.spring.f5_AOP.cglib_proxy.bean.CglibBean;
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
@ContextConfiguration(locations = {"classpath:applicationContext_f5_AOP_CglibProxy.xml"})
public class CglibProxy_Test {
    @Autowired
    private CglibBean cglibBean;
    @Autowired
    private CglibBean cglibProxyBean1;
    @Autowired
    private CglibBean cglibProxyBean2;

    @Test
    public void test(){
        log.info("被代理类：{}", cglibBean.getClass());
        cglibBean.functionA();

        log.info("");

        log.info("代理类1：{}", cglibProxyBean1.getClass());
        cglibProxyBean1.functionA();

        log.info("");

        log.info("代理类2：{}", cglibProxyBean2.getClass());
        cglibProxyBean2.functionA();
    }
}
