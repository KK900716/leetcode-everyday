package com.SpringTest;

import com.SpringTest.spring.Target;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.SpringTest.config");
        Target target= (Target) applicationContext.getBean("target");
        target.fun();
    }
}
