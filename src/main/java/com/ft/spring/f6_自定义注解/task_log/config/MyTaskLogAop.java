package com.ft.spring.f6_自定义注解.task_log.config;

import com.ft.spring.f6_自定义注解.task_log.annotation.MyTaskLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description: Spring AOP
 * @Author: fangt
 * @CreateTime: 2021/7/7 17:11
 */
@Slf4j
@Component
@Aspect
public class MyTaskLogAop {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSSSSS");

    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.ft.spring.f6_自定义注解.task_log.annotation.MyTaskLog)")
    public void myTaskLog(){ }

    @Around("myTaskLog() && @annotation(taskLog)")
    public Object around(ProceedingJoinPoint joinPoint, MyTaskLog taskLog) throws Throwable {
        // 获取注解的参数
        String taskName = "".equals(taskLog.value()) ? "" : "【" + taskLog.value() + "】";
        // 获取方法 message 参数
        StringBuilder message = new StringBuilder();
        Object[] args = joinPoint.getArgs();
        if(args != null && args.length > 0 && args[args.length - 1] instanceof StringBuilder) {
            message = (StringBuilder) args[args.length - 1];
        }

        LocalDateTime start = LocalDateTime.now();
        message.append(taskName).append("任务开始于：").append(start.format(formatter)).append("\n");
        // 执行注解方法
        Object obj = joinPoint.proceed();
        LocalDateTime end = LocalDateTime.now();
        message.append(taskName).append("任务结束于：").append(end.format(formatter)).append("，");
        message.append("任务总耗时：").append(Duration.between(start, end).toMillis()).append("ms");

        // 存储/打印/发送 message 消息
        log.info("存储/打印/发送 message 消息：\n{}", message);
        return obj;
    }
}