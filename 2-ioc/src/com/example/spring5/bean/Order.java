package com.example.spring5.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Package: com.example.spring5.bean
 * @ClassName: Order
 * @Author: guoyy
 * @Description: 测试bean的生命周期
 * @Date: 2021/11/23 上午1:03
 * @Version: 1.0
 */
public class Order{
    private String oname;

    public Order() {
        System.out.println("第一步 执行无参构造方法");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步 调用set方法");
    }

    public void initMethod(){
        System.out.println("第三步 执行初始化方法");
    }

    public void destroyMethod(){
        System.out.println("第五步 执行销毁方法");
    }

}
