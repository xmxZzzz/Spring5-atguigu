package com.example.spring5.test;

import com.example.spring5.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: spring5-code
 * @Package: com.example.spring5.test
 * @ClassName: Test
 * @Author: guoyy
 * @Description:
 * @Date: 2021/8/29 上午3:06
 * @UpdateDate: 2021/8/29 上午3:06
 * @Version: 1.0
 */
public class TestDemo {

    @Test
    public void testUser(){
        //1、加载spring配置文件bean1.xml
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        //2、获取配置的bean对象User
        User user = applicationContext.getBean("user", User.class);
        //3、使用User
        System.out.println(user);
        user.say();
    }

}
