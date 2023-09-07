package com.ft.spring.f6_自定义注解.task_log;

import com.ft.spring.f6_自定义注解.task_log.annotation.MyTaskLog;
import com.ft.spring.f6_自定义注解.task_log.config.MyTaskLogAop;
import com.ft.spring.f6_自定义注解.task_log.task.MyTaskService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description: 自定义注解 测试
 * @Author: fangt
 * @CreateTime: 2021/7/12 14:21
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_f6_自定义注解_TaskLog.xml"})
public class TaskLogAnnotationTest {
    @Autowired
    private MyTaskService myTaskService;

    /**
     * 自定义注解：任务日志
     * {@link MyTaskLog}、{@link MyTaskLogAop}
     */
    @Test
    public void test(){
        myTaskService.task01("111", "222", "333", new StringBuilder());
        myTaskService.task02("111", "222", "333");
        myTaskService.task03("111", "222", "333");
    }
}
