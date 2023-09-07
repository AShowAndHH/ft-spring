package com.ft.spring.f3_Bean.bean_prototype;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/13 13:16
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PrototypeBean {
    @Autowired
    Bean04 bean04;

    @Override
    public String toString() {
        return "PrototypeBean@" + Integer.toHexString(hashCode()) + " -- " + bean04;
    }
}
