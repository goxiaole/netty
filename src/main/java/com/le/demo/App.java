package com.le.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAspectJAutoProxy(exposeProxy=true)
@SpringBootApplication
@MapperScan(" com.le.demo.com.le.demo.controller")
@EnableTransactionManagement
public class App  {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
