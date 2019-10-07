package com.le.demo.com.le.demo.controller;

import org.springframework.aop.framework.AopContext;
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
        userMapper.insert(User.builder().id(1L).name("我没有事物").build());
        try {
            IndexController IndexController=(IndexController)AopContext.currentProxy();
            IndexController.b();

        }catch (Exception e){
        }finally {
            System.out.println("执行完操作...");
        }
        int i= 1/0;
        }
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void b(){
        userMapper.insert(User.builder().id(2L).name("我有事物").build());

    }
}


