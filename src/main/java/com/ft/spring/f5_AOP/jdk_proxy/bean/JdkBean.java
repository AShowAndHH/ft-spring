package com.ft.spring.f5_AOP.jdk_proxy.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/11/2 12:36
 */
@Slf4j
@Component
public class JdkBean implements JdkBeanInterface {
    @Override
    public void functionA() {
        log.info("functionA 执行");
        functionB();
    }

    @Override
    public void functionB() {
        log.info("functionB 执行");
    }
}
