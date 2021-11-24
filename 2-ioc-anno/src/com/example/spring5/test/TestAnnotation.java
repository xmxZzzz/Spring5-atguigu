package com.example.spring5.test;

import com.example.spring5.config.UserConfiguration;
import com.example.spring5.dao.UserDao;
import com.example.spring5.dao.UserDaoImpl;
import com.example.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: spring5-code
 * @Package: com.example.spring5.test
 * @ClassName: TestAnnotation
 * @Author: guoyy
 * @Description:
 * @Date: 2021/9/15 上午1:18
 * @UpdateDate: 2021/9/15 上午1:18
 * @Version: 1.0
 */
public class TestAnnotation {
    /*
     * @Method test
     * @Version  1.0
     * @Description 使用xml配置组件扫描
     * @param
     * @Return void
     * @Exception
     * @Date 2021/11/25 上午1:47
     */
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

//        UserController userController = context.getBean("userController", UserController.class);
//        System.out.println(userController);

        UserService userService = context.getBean("userService", UserService.class);
        userService.add();

        UserDao userDao = context.getBean("userDaoImpl", UserDaoImpl.class);
        userDao.print();
    }

    /*
     * @Method testAnno
     * @Version  1.0
     * @Description 测试完全注解开发,，使用配置类进行组件扫描
     * @param
     * @Return void
     * @Exception
     * @Date 2021/11/25 上午1:47
     */
    @Test
    public void testAnno(){
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfiguration.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }
}
