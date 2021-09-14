package com.example.spring5.test;

import com.example.spring5.dao.UserDao;
import com.example.spring5.dao.UserDaoImpl;
import com.example.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
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
}
