package com.example.spring5.dao;

import org.springframework.stereotype.Repository;

/**
 * @ProjectName: spring5-code
 * @Package: com.example.spring5.dao
 * @ClassName: UserDaoImpl
 * @Author: guoyy
 * @Description:
 * @Date: 2021/9/15 上午1:05
 * @UpdateDate: 2021/9/15 上午1:05
 * @Version: 1.0
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void print() {
        System.out.println("UserDaoImpl print......");
    }
}
