package com.ft.spring.spring_03_Bean.bean_prototype;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/13 13:16
 */
@Component
@ToString
public class SingletonBean {
    @Autowired
    private PrototypeBean prototypeBean;
}
