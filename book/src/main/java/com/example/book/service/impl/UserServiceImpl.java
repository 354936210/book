package com.example.book.service.impl;

import com.example.book.dao.UserDao;
import com.example.book.dao.impl.UserDaoImpl;
import com.example.book.pojo.User;
import com.example.book.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public int registUser(User user) {
       return userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            return false;
        }
        return true;
    }
}
