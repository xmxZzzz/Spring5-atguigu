package com.example.spring5.transaction.test;

import com.example.spring5.transaction.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestTransaction {

    @Test
    public void testJdbcTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney("lucy", "mary",100);
    }
}
