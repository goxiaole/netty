package com.le.demo.com.le.demo.controller;

import com.le.demo.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={App.class})
public class SampleTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IndexController indexController;

    @Test
    public void testSelect() {
        indexController.a();
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

}