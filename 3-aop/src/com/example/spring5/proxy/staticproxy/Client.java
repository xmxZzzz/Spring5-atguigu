package com.example.spring5.proxy.staticproxy;

public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        ProxyFactory proxyFactory = new ProxyFactory(teacherDao);
        int add = proxyFactory.add(1, 2);
        System.out.println(add);

        String one = proxyFactory.update("one");
        System.out.println(one);
    }
}
