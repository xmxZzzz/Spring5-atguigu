package com.example.spring5.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Package: com.example.spring5.aopanno
 * @ClassName: UserProxy
 * @Author: guoyy
 * @Description: 增强类
 * @Date: 2021/11/25 上午3:52
 * @Version: 1.0
*/

@Component
@Aspect
public class UserProxy {

    /*
    执行顺序：
        (1) before around -> before -> add -> after around -> after -> afterReturning
        (2) before around -> before ->  after -> afterThrowing
     */

    //前置通知
    @Before(value = "execution(* com.example.spring5.aopanno.User.add(..))")
    public void before(){
        System.out.println("before...");
    }

    //后置通知
    @AfterReturning(value = "execution(* com.example.spring5.aopanno.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }

    //异常通知
    @AfterThrowing(value = "execution(* com.example.spring5.aopanno.User.add(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }

    //最终通知
    @After(value = "execution(* com.example.spring5.aopanno.User.add(..))")
    public void after(){
        System.out.println("after...");
    }

    //环绕通知
    @Around(value = "execution(* com.example.spring5.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before around ...");
        proceedingJoinPoint.proceed();
        System.out.println("after around ...");

    }
}
