package com.jdkDL;

public class InteImpl implements Inte{
    @Override
    public String sayHello(String name) {
        String s=name+"hello";
        System.out.println(s);
        return s;
    }

    @Override
    public String goodBye() {
        System.out.println("goodBye");
        return "goodBye";
    }
}
