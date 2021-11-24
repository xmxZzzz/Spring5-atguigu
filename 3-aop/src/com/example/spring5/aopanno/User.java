package com.example.spring5.aopanno;

import org.springframework.stereotype.Component;

/**
 * @Package: com.example.spring5.aopanno
 * @ClassName: User
 * @Author: guoyy
 * @Description: 待增强的类
 * @Date: 2021/11/25 上午3:51
 * @Version: 1.0
*/
@Component
public class User {
    public void add(int a,int b){
//        int res = 10/0;
        System.out.println("a+b="+(a+b));
    }
}
