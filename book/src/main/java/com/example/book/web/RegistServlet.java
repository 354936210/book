package com.example.book.web;

import com.example.book.dao.UserDao;
import com.example.book.dao.impl.UserDaoImpl;
import com.example.book.pojo.User;
import com.example.book.service.UserService;
import com.example.book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String checkcode = req.getParameter("checkcode");

//       * 2.检查验证码是否正确
        if(checkcode.equalsIgnoreCase("abcde")){
//            正确
//                    * 3.检查用户名是否可用
//                    *  可用
//                    *    调用Service保存到数据库
//                    *    跳转到注册成功页面 regist_success.html页面
//                    *  不可用
//                    *    跳回注册页面
            UserService userService = new UserServiceImpl();
            if(userService.existUsername(username)){
                System.out.println("用户名已存在");
                req.getRequestDispatcher("/pages/regist.html").forward(req,resp);

            }else{
                userService.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/regist_success.html").forward(req,resp);
            }

        }else{
//            不正确
//            跳回注册页面
            req.getRequestDispatcher("/pages/regist.html").forward(req,resp);
        }

    }
}
