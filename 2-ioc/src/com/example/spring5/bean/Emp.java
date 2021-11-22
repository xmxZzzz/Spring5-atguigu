package com.example.spring5.bean;

/**
 * @Package: com.example.spring5.bean
 * @ClassName: Emp
 * @Author: guoyy
 * @Description: 自动装配
 * @Date: 2021/11/23 上午1:35
 * @Version: 1.0
*/
public class Emp {
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }
}

