package com.example.book.test;

import com.example.book.dao.UserDao;
import com.example.book.dao.impl.UserDaoImpl;
import com.example.book.pojo.User;
import org.junit.jupiter.api.Test;

class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    void queryUserByUsername() {

        if(userDao.queryUserByUsername("addddin")==null){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名已存在");
        }

    }

    @Test
    void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"admin1","234567","283741987@qq.com")));
    }

    @Test
    void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("admin","12345236")==null){
            System.out.println("用户名或密码错误");
        }else{
            System.out.println("登录成功");
        };
    }
}