package com.jdkDL;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class Ta {
    public static void main(String[] args) {
        InteImpl InteImpl=new InteImpl();
        InvocationHandler handler=new DaiLi(InteImpl);
        ClassLoader classLoader=InteImpl.getClass().getClassLoader();
        Class[] intes = InteImpl.getClass().getInterfaces();
        Inte i= (Inte) Proxy.newProxyInstance(classLoader,intes,handler);
        System.out.println("动态代理对象的类型："+i.getClass().getName());
        i.sayHello("ljc");
    }
}