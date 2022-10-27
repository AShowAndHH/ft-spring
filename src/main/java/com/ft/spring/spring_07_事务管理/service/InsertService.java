package com.ft.spring.spring_07_事务管理.service;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/26 9:32
 */
public interface InsertService {
    void insert();

    default void transaction_insert(){};
}
