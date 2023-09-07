package com.ft.spring.f5_AOP.cglib_proxy.config;

import com.ft.spring.f5_AOP.cglib_proxy.bean.CglibBean;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/11/3 13:11
 */
@Slf4j
@Configuration
public class CglibProxyConfig {
    /**
     * 被代理类
     */
    @Autowired
    private CglibBean cglibBean;

    /**
     * 代理类1
     */
    @Bean
    public CglibBean cglibProxyBean1 (MethodInterceptor methodInterceptor1){
        return createProxyBean(methodInterceptor1);
    }

    /**
     * 代理类2
     */
    @Bean
    public CglibBean cglibProxyBean2 (MethodInterceptor methodInterceptor2){
        return createProxyBean(methodInterceptor2);
    }

    /**
     * 代理逻辑1：方法间调用，会再次触发代理
     */
    @Bean
    public MethodInterceptor methodInterceptor1(){
        return new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if(method.getName().contains("function")) {
                    log.info("{} 前执行代理逻辑1", method.getName());
                    // 调用代理类方法
                    Object returnVaule = methodProxy.invokeSuper(o, args);
                    log.info("{} 后执行代理逻辑1", method.getName());
                    return returnVaule;
                }
                return methodProxy.invokeSuper(o, args);
            }
        };
    }

    /**
     * 代理逻辑2：方法间调用，不会再次触发代理
     */
    @Bean
    public MethodInterceptor methodInterceptor2(){
        return new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if(method.getName().contains("function")) {
                    log.info("{} 前执行代理逻辑2", method.getName());
                    // 调用被代理类方法
                    Object returnVaule = method.invoke(cglibBean, args);
                    log.info("{} 后执行代理逻辑2", method.getName());
                    return returnVaule;
                }
                return method.invoke(cglibBean, args);
            }
        };
    }

    private CglibBean createProxyBean (MethodInterceptor cglibProxyInterceptor){
        Enhancer enhancer = new Enhancer();
        // 生成动态代理类
        enhancer.setSuperclass(cglibBean.getClass());
        enhancer.setCallback(cglibProxyInterceptor);
        CglibBean cglibProxyBean = (CglibBean) enhancer.create();
        return cglibProxyBean;
    }
}
