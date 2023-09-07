package com.ft.spring.f5_AOP.jdk_proxy.config;

import com.ft.spring.f5_AOP.jdk_proxy.bean.JdkBeanInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/11/3 12:44
 */
@Slf4j
@Configuration
public class JdkProxyConfig {
    /**
     * 被代理类
     */
    @Autowired
    private JdkBeanInterface jdkBean;

    /**
     * 代理类
     */
    @Bean
    public JdkBeanInterface jdkProxyBean(InvocationHandler invocationHandler){
        // 构建参数
        ClassLoader classLoader = jdkBean.getClass().getClassLoader();
        Class[] interfaces = jdkBean.getClass().getInterfaces();
        // 生成动态代理类
        JdkBeanInterface jdkProxyBean = (JdkBeanInterface) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return jdkProxyBean;
    }

    /**
     * 代理逻辑
     */
    @Bean
    public InvocationHandler invocationHandler (){
        return new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                if(method.getName().contains("function")) {
                    log.info("{} 前执行代理逻辑", method.getName());
                    Object returnVaule = method.invoke(jdkBean, args);
                    log.info("{} 后执行代理逻辑", method.getName());
                    return returnVaule;
                }
                return method.invoke(jdkBean, args);
            }
        };
    }
}
