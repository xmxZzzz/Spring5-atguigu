package com.example.spring5.test;

import com.example.spring5.aopanno.User;
import com.example.spring5.aopxml.Book;
import com.example.spring5.config.ConfigAop;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    /*
     * @Method testAopAnno
     * @Version  1.0
     * @Description 测试基于AspectJ的注解方式
     * @Date 2021/11/26 上午1:20
     */
    @Test
    public void testAopAnno(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add(1, 2);
    }

    /*
     * @Method testAopXml
     * @Version  1.0
     * @Description 测试基于AspectJ的配置文件方式
     * @Date 2021/11/26 上午1:22
     */
    @Test
    public void testAopXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }

    /*
     * @Method testAopConfig
     * @Version  1.0
     * @Description 测试完全注解开发
     * @Date 2021/11/26 上午1:26
     */
    @Test
    public void testAopConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigAop.class);
        User user = context.getBean("user", User.class);
        user.add(1, 2);
    }

}
