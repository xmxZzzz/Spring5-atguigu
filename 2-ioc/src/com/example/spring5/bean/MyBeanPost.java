package com.example.spring5.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Package: com.example.spring5.bean
 * @ClassName: MyBeanPost
 * @Author: guoyy
 * @Description: 后置处理器
 * @Date: 2021/11/23 上午1:18
 * @Version: 1.0
*/
public class MyBeanPost implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("        初始化之前执行的方法");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("        初始化之后执行的方法");
        return bean;
    }
}
