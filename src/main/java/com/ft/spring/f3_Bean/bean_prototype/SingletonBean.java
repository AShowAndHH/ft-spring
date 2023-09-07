package com.ft.spring.f3_Bean.bean_prototype;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/13 13:16
 */
@Component
public class SingletonBean {
    @Autowired
    private PrototypeBean prototypeBean;

    @Override
    public String toString() {
        return "SingletonBean@" + Integer.toHexString(hashCode()) + " -- " + prototypeBean;
    }
}
