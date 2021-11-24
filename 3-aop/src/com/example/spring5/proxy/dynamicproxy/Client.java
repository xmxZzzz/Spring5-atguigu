package com.example.spring5.proxy.dynamicproxy;

public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        ProxyFactory proxyFactory = new ProxyFactory(teacherDao);
        ITeacherDao instance = (ITeacherDao) proxyFactory.getProxyInstance();
        int res = instance.add(1, 2);
        System.out.println(res);

        String resStr = instance.update("one");
        System.out.println(resStr);

    }
}
