package com.ft.spring.f6_自定义注解.task_log.task;

import com.ft.spring.f6_自定义注解.task_log.annotation.MyTaskLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: fangt
 * @CreateTime: 2021/7/12 17:11
 */
@Slf4j
@Service
public class MyTaskService{
    @MyTaskLog("测试任务01")
    public void task01(String param1, String param2, String param3, StringBuilder message){
        message.append("任务执行日志1").append("\n");
        log.info("【测试任务01】执行");
        message.append("任务执行日志2").append("\n");
        message.append("任务执行日志3").append("\n");
    }

    @MyTaskLog("测试任务02")
    public void task02(String param1, String param2, String param3){
        log.info("【测试任务02】执行");
    }

    @MyTaskLog
    public void task03(String param1, String param2, String param3){
        log.info("【测试任务03】执行");
    }
}
