package com.ft.spring.spring_05_AOP.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/11/2 12:36
 */
@Slf4j
@Service
public class CglibBean {
    public void exe_a() {
        exe_b();
    }

    public void exe_b() {
        log.info("我是 Cglib Bean");
    }
}
