package com.ft.spring.f4_Bean_LifeCycle.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/14 9:31
 */
@Slf4j
public abstract class AbstractLifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean {
    public AbstractLifeCycleBean(){
        log.info("{} 实例化", this.getClass().getSimpleName());
    }

    @Override
    public void setBeanName(String name) {
        log.info("{} 感知器【BeanNameAware】：BeanName = {}", this.getClass().getSimpleName(), name);
    }

    @PostConstruct
    public void postConstruct(){
        log.info("{} 初始化方法【@PostConstruct】", this.getClass().getSimpleName());
    }

    @PreDestroy
    public void preDestroy(){
        log.info("{} 销毁方法【@PreDestroy】", this.getClass().getSimpleName());
    }

    @Override
    public void afterPropertiesSet(){
        log.info("{} 初始化方法【实现 InitializingBean 接口 afterPropertiesSet 方法】", this.getClass().getSimpleName());
//        log.info("{} 初始化", this.getClass().getSimpleName());
    }

    @Override
    public void destroy(){
        log.info("{} 销毁方法【实现 DisposableBean 接口 destroy 方法】", this.getClass().getSimpleName());
//        log.info("{} 销毁", this.getClass().getSimpleName());
    }
}
