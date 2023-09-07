package com.ft.spring.f3_Bean;

import com.ft.spring.f3_Bean.bean_prototype.SingletonBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/13 13:33
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_f3_Bean.xml"})
public class Bean_Prototype_Test {
    @Autowired
    private SingletonBean singletonBean;

    @Test
    public void test(){
        log.info("{}", singletonBean);
        log.info("{}", singletonBean);
        log.info("{}", singletonBean);
    }
}
