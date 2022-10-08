package com.ft.spring.spring_02_IOC容器;

import com.ft.spring.spring_02_IOC容器.bean.IOCBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/9/30 9:28
 */
@Slf4j
public class TestIOC_ApplicationContext {

    @Test
    public void test(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:applicationContext_02_IOC容器.xml");
        log.info("{}", applicationContext);
        IOCBean bean = applicationContext.getBean(IOCBean.class);
        log.info("{}", bean);
    }
}
