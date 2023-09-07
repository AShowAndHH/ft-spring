package com.ft.spring.f3_Bean.bean_prototype;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2023/8/15 11:11
 */
@Component
public class Bean04 {
    @Override
    public String toString() {
        return "Bean04@" + Integer.toHexString(hashCode());
    }
}
