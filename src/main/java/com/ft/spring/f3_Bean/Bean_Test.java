package com.ft.spring.f3_Bean;

import com.ft.spring.f3_Bean.bean.Bean01;
import com.ft.spring.f3_Bean.bean.Bean02;
import com.ft.spring.f3_Bean.bean.Bean03;
import com.ft.spring.f3_Bean.bean.IBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/13 12:07
 */

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_f3_Bean.xml"})
public class Bean_Test {
    @Autowired
    private Bean01 beanAutowiredByType01;
    @Autowired
    private Bean02 beanAutowiredByType02;

    @Autowired
    private IBean bean01;
    @Autowired
    private IBean bean02;

    @Autowired @Qualifier("bean01")
    private IBean bean;

    @Autowired(required = false)
    private Bean03 bean03;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private List<IBean> beanList;

    @Test
    public void test(){
        // @Autowired 默认注入方式为 ByType，所以类型一致即可注入
        log.info("1、注入策略（byType）");
        log.info("{}", beanAutowiredByType01);
        log.info("{}", beanAutowiredByType02);
        log.info("");

        // 默认根据 byType 注入，当匹配大于1时会根据 byName 注入
        log.info("2、注入策略（byName）");
        log.info("{}", bean01);
        log.info("{}", bean02);
        log.info("");

        // 使用 @Qualifier 使 @Autowired 自动注入的策略就从 byType 转变成 byName
        log.info("3、注入策略（byName，配合 @Qualifie 使用）");
        log.info("{}", bean);
        log.info("");

        // required=true(默认)，找不到 Bean，会抛出异常：NoSuchBeanDefinitionException
        // required=false，找不到 Bean，注入 null
        log.info("4、注入的 required 属性");
        log.info("{}", bean03);
        log.info("");

        // 对于那些众所周知的解析依赖接口，将自动解析
        log.info("5、公共接口注入");
        log.info("{}", applicationContext);
        try {
            log.info("{}", applicationContext.getBean("bean03"));
        }catch (NoSuchBeanDefinitionException e){
            log.info("{}", e.getMessage());
        }
        log.info("");

        // @Component 可以配合 @Order(n) 自定义注入顺序
        log.info("6、注入泛型 List");
        beanList.forEach(x -> log.info("{}", x));
        log.info("");
    }
}
