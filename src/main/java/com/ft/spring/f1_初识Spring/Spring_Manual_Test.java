package com.ft.spring.f1_初识Spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 读取 Spring 配置文件（手动读取）
 * @Author fangt
 * @CreateTime 2022/9/28 12:17
 */
@Slf4j
public class Spring_Manual_Test {
    /**
     * 1、读取xml配置文件：new ClassPathXmlApplicationContext("applicationContext.xml");
     * 2、读取类配置文件（@Configuration 或者 @Component）：new AnnotationConfigApplicationContext(Config01.class, Config02.class, Config03.class);
     */
    private ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_f1_初识Spring.xml");

    private SpringBean bean = applicationContext.getBean(SpringBean.class);

    @Test
    public void test() {
        /* 这里显式注册一个钩子函数；在Spring项目启动时，Spring会自己注册一个钩子函数
         * 1、注册的时候，不存在才注册
         * 2、作用：Spring定义的钩子函数中，会去执行 DisposableBean.destory()和被 @PreDestroy 修饰的方法
         */
        applicationContext.registerShutdownHook();

        log.info("{}", bean);
    }
}