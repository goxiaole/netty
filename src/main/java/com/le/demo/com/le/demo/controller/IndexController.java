package com.le.demo.com.le.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void a(){

        userMapper.insert(User.builder().id(6L).name("2").build());
        System.out.println("a");
        b();
        }

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void b(){
        userMapper.insert(User.builder().id(7L).name("1").build());
       int i= 1/0;
        System.out.println("b");
    }
}
