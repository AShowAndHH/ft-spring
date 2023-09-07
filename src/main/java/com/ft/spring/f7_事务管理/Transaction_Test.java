package com.ft.spring.f7_事务管理;

import com.ft.spring.f7_事务管理.service.InsertService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/26 9:31
 */

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_f7_Transaction.xml"})
public class Transaction_Test {
    @Autowired
    private List<InsertService> insertServiceList;

    @Test
    public void test() {
        insertServiceList.forEach(x->{
            try {
                x.insert();
            }catch (Exception ignored){ }
        });
    }
}

