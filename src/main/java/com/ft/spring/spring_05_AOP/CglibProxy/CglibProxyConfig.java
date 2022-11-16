package com.ft.spring.spring_05_AOP.CglibProxy;

import com.ft.spring.spring_05_AOP.common.CglibBean;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.factory.annotation.Autowired;
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
     * 代理逻辑1：调用代理类父方法 exe_a
     * 方法间调用时，调用的是代理类的方法 exe_b，会再次触发代理
     */
    @Bean
    public MethodInterceptor cglibProxyInterceptor1(){
        return new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                log.info("{} cglibProxy1 before", method.getName());
                // 调用代理类父方法
                Object returnVaule = methodProxy.invokeSuper(o, args);
                log.info("{} cglibProxy1 after", method.getName());
                return returnVaule;
            }
        };
    }

    /**
     * 代理逻辑2：调用被代理类方法 exe_a
     * 方法间调用时，调用的是被代理类的方法 exe_b，不会再次触发代理
     */
    @Bean
    public MethodInterceptor cglibProxyInterceptor2(){
        return new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                log.info("{} cglibProxy2 before", method.getName());
                // 调用被代理类方法
                Object returnVaule = method.invoke(cglibBean, args);
                log.info("{} cglibProxy2 after", method.getName());
                return returnVaule;
            }
        };
    }

    /**
     * 代理类1
     */
    @Bean
    public CglibBean cglibProxyBean1 (MethodInterceptor cglibProxyInterceptor1){
        return createCglibProxyBean(cglibProxyInterceptor1);
    }

    /**
     * 代理类2
     */
    @Bean
    public CglibBean cglibProxyBean2 (MethodInterceptor cglibProxyInterceptor2){
        return createCglibProxyBean(cglibProxyInterceptor2);
    }

    private CglibBean createCglibProxyBean (MethodInterceptor cglibProxyInterceptor){
        Enhancer enhancer = new Enhancer();
        // 生成动态代理类
        enhancer.setSuperclass(cglibBean.getClass());
        enhancer.setCallback(cglibProxyInterceptor);
        CglibBean cglibProxyBean = (CglibBean) enhancer.create();
        return cglibProxyBean;
    }
}
