package com.example.spring5.bean;

import org.springframework.beans.factory.FactoryBean;

import java.util.Arrays;

/**
 * @Package: com.example.spring5.bean
 * @ClassName: MyBean
 * @Author: guoyy
 * @Description: 测试工厂Bean：FactoryBean
 * @Date: 2021/11/23 上午12:33
 * @Version: 1.0
*/
public class MyBean implements FactoryBean<Course> {
    /*
     * @Method getObject
     * @Version  1.0
     * @Description 定义返回的bean类型
     * @param
     * @Return com.example.spring5.bean.Course
     * @Exception
     * @Date 2021/11/23 上午12:32
     */
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname(Arrays.asList("Spring"));
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
