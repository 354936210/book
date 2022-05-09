package com.example.book.service;

import com.example.book.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     * @return
     */
    public int registUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回null说明登录失败 返回有值说明登录成功
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在 返回false表示用户名可用
     */
    public boolean existUsername(String username);

}
