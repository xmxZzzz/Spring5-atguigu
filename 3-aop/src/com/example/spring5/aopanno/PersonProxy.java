package com.example.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class PersonProxy {

    /*
    @Order(数字):数字越小，增强类的优先级越高
     */

    @Pointcut(value="execution(* com.example.spring5.aopanno.User.add(..))")
    public void commonPoint(){}

    //前置通知
    @Before(value = "commonPoint()")
    public void newBefore(){
        System.out.println(" PersonProxy new before...");
    }
}
