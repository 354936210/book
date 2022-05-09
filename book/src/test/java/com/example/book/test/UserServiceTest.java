package com.example.book.test;

import com.example.book.pojo.User;
import com.example.book.service.UserService;
import com.example.book.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    void registUser() {
       int i = userService.registUser(new User(null,"admin3","333333","13431@qq.com"));
        System.out.println(i);
    }


    @Test
    void login() {
        System.out.println(userService.login(new User(null,"admin2","222222",null)));
    }

    @Test
    void existUsername() {
       if(userService.existUsername("admin3")){
           System.out.println("用户名已存在");
       }else{
           System.out.println("用户名可以使用");
       }
    }
}