package com.example.spring5.proxy.staticproxy;

public class TeacherDao implements ITeacherDao{

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
