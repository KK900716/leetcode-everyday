package com.jdkDL;

import javax.security.auth.Subject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DaiLi implements InvocationHandler {
    private Object object;

    public DaiLi(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理函数");
        System.out.println("method:"+method);
        Object returnValue =method.invoke(object,args);
        System.out.println("执行完成");
        return returnValue;
    }


}
