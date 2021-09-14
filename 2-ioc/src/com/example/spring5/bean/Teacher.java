package com.example.spring5.bean;

import java.util.List;

/**
 * @ProjectName: spring5-code
 * @Package: spring5.bean
 * @ClassName: Teacher
 * @Author: guoyy
 * @Description:
 * @Date: 2021/9/2 上午2:58
 * @UpdateDate: 2021/9/2 上午2:58
 * @Version: 1.0
 */
public class Teacher {
    private List<String> cname;
    private String tname;

    public void setCname(List<String> cname) {
        this.cname = cname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public List<String> getCname() {
        return cname;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "cname=" + cname +
                ", tname='" + tname + '\'' +
                '}';
    }
}
