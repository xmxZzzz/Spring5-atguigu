package com.example.spring5.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: spring5-code
 * @Package: com.example.spring5.service
 * @ClassName: UserService
 * @Author: guoyy
 * @Description:
 * @Date: 2021/9/15 上午12:53
 * @UpdateDate: 2021/9/15 上午12:53
 * @Version: 1.0
 */
@Service(value = "userService")
public class UserService {
    public void add(){
        System.out.println("UserService add......");

    }
}
