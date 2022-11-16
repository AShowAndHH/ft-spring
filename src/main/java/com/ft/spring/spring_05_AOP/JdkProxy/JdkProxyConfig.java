package com.ft.spring.spring_05_AOP.JdkProxy;

import com.ft.spring.spring_05_AOP.common.JdkBeanInterface;
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
     * 代理逻辑
     */
    @Bean
    public InvocationHandler jdkProxyHandler (){
        return new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                log.info("{} jdkProxy before", method.getName());
                Object returnVaule = method.invoke(jdkBean, args);
                log.info("{} jdkProxy after", method.getName());
                return returnVaule;
            }
        };
    }

    /**
     * 代理类
     */
    @Bean
    public JdkBeanInterface jdkProxyBean(InvocationHandler jdkProxyHandler){
        // 构建参数
        ClassLoader classLoader = jdkBean.getClass().getClassLoader();
        Class[] interfaces = jdkBean.getClass().getInterfaces();
        // 生成动态代理类
        JdkBeanInterface jdkProxyBean = (JdkBeanInterface) Proxy.newProxyInstance(classLoader, interfaces, jdkProxyHandler);
        return jdkProxyBean;
    }
}
