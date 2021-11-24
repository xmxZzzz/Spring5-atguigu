package com.example.spring5.proxy.cglib;

public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        ProxyFactory proxyFactory = new ProxyFactory(teacherDao);
        TeacherDao proxyInstance = (TeacherDao) proxyFactory.getProxyInstance();

        int res = proxyInstance.add(1, 2);
        System.out.println(res);

        String resStr = proxyInstance.update("one");
        System.out.println(resStr);


    }
}
