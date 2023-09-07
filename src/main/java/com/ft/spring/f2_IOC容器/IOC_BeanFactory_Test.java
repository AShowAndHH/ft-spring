package com.ft.spring.f2_IOC容器;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/9/30 9:28
 */
@Slf4j
public class IOC_BeanFactory_Test {

    @Test
    public void test(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext_f2_IOC容器.xml"));
        log.info("{}", beanFactory);
        IOCBean bean = beanFactory.getBean(IOCBean.class);
        log.info("{}", bean);
    }
}
