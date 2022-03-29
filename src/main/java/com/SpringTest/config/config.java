package com.SpringTest.config;

import com.SpringTest.spring.TestPojo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.SpringTest.spring")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class config{

}
