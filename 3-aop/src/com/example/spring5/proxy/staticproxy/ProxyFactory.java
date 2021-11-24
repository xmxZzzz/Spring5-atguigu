package com.example.spring5.proxy.staticproxy;

public class ProxyFactory implements ITeacherDao{

    private ITeacherDao target;

    public ProxyFactory(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("静态代理开始执行add。。。");
        int res = target.add(a, b)+10;
        System.out.println("静态代理结束执行add。。。");
        return res;
    }

    @Override
    public String update(String id) {
        System.out.println("静态代理开始执行update。。。");
        String res = target.update(id)+" static";
        System.out.println("静态代理结束执行update。。。");
        return res;
    }
}
