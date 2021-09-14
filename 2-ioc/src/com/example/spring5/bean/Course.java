package com.example.spring5.bean;

import java.util.List;

/**
 * @ProjectName: spring5-code
 * @Package: spring5.bean
 * @ClassName: Course
 * @Author: guoyy
 * @Description:
 * @Date: 2021/9/2 上午2:53
 * @UpdateDate: 2021/9/2 上午2:53
 * @Version: 1.0
 */
public class Course {
    private List<String> cname;

    public void setCname(List<String> cname) {
        this.cname = cname;
    }

    public List<String> getCname() {
        return cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname=" + cname +
                '}';
    }
}
