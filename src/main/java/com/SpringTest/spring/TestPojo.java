package com.SpringTest.spring;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Component("myAspect")
@Aspect
public class TestPojo {
    private final String test="test";
    @Pointcut("execution(* com.SpringTest.spring.Target.*(..))")
    public void pointcut(){}
//    @Before("pointcut()")
//    public void before(){
//        System.out.println("before");
//    }
//    @AfterReturning("pointcut()")
//    public void after(){
//        System.out.println("after");
//    }
    @Around("pointcut()")
    public void around(){
        System.out.println("around");
    }
}
