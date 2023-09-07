package com.ft.spring.f4_Bean_LifeCycle.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description Bean 后置处理器(BeanPostProcessor)
 * @Author fangt
 * @CreateTime 2023/8/15 14:09
 */
@Slf4j
@Component
public class LifeCycleBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.contains("lifeCycleBean")) {
            log.info("{} Bean 后置处理器【BeanPostProcessor】初始化前方法【postProcessBeforeInitialization】",
                    bean.getClass().getSimpleName());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.contains("lifeCycleBean")) {
            log.info("{} Bean 后置处理器【BeanPostProcessor】初始化后方法【postProcessAfterInitialization】",
                    bean.getClass().getSimpleName());
        }
        return bean;
    }
}
