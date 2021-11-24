package com.example.spring5.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private ITeacherDao target;

    public ProxyFactory(ITeacherDao target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("JDK代理开始执行。。。");
                Object res = method.invoke(target, objects);
                System.out.println("JDK代理结束执行。。。");
                return res;
            }
        });
    }
}
