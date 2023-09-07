package com.ft.spring.f2_IOC容器;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/8 12:07
 */
@Slf4j
@Component
public class IOCBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("init bean");
    }
}
