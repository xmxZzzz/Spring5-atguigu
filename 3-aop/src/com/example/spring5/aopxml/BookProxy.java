package com.example.spring5.aopxml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Package: com.example.spring5.aopxml
 * @ClassName: BookProxy
 * @Author: guoyy
 * @Description: 增强类，包含before和around通知
 * @Date: 2021/11/26 上午1:14
 * @Version: 1.0
*/
public class BookProxy {

    public void before(){
        System.out.println("before...");
    }

    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before around....");
        proceedingJoinPoint.proceed();
        System.out.println("after around...");
    }
}
