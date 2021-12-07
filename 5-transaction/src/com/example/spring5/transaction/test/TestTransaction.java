package com.example.spring5.transaction.test;

import com.example.spring5.transaction.annotation.config.TxConfig;
import com.example.spring5.transaction.annotation.service.AccountService;
import com.example.spring5.transaction.propagation.service.HandleAccountService;
import com.example.spring5.transaction.xml.service.AccountXMLService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestTransaction {

    @Test
    public void testJdbcTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney("lucy", "mary",100);
    }

    /*
     * @Method testPropagation
     * @Version  1.0
     * @Description 测试事务的传播
     * @Return void
     * @Date 2021/12/8 上午1:48
     */
    @Test
    public void testPropagation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        HandleAccountService handleAccountService = context.getBean("handleAccountService", HandleAccountService.class);

        //测试Propagation.REQUIRED
//        handleAccountService.testRequiredPropagation();

        //测试Propagation.SUPPORTS
//        handleAccountService.testSupportsPropagation();

        //测试Propagation.NOT_SUPPORTS
//        handleAccountService.testNotSupportsPropagation();

        //测试Propagation.MANDATORY
//        handleAccountService.testMandatoryPropagation();

        //测试Propagation.NEVER
//        handleAccountService.testNeverPropagation();

        //测试Propagation.REQUIRED_NEW
//        handleAccountService.testRequiredNewPropagation();

        //测试Propagation.NESTED
        handleAccountService.testNestedPropagation();
    }

    /*
     * @Method testTransactionXML
     * @Version  1.0
     * @Description 测试基于xml配置文件的事务
     * @Date 2021/12/8 上午5:31
     */
    @Test
    public void testTransactionXML(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        AccountXMLService accountService = context.getBean("accountXMLService", AccountXMLService.class);
        accountService.accountMoney("tom", "jerry",100);
    }

    /*
     * @Method testTransactionByAllAnnotation
     * @Version  1.0
     * @Description 测试完全注解开发的事务
     * @Date 2021/12/8 上午5:34
     */
    @Test
    public void testTransactionByAllAnnotation(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney("jerry", "tom", 100);
    }
}
