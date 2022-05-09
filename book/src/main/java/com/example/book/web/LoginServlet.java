package com.example.book.web;

import com.example.book.pojo.User;
import com.example.book.service.UserService;
import com.example.book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService userService = new UserServiceImpl();
        if(userService.login(new User(null,username,password,null))==null){
            req.getRequestDispatcher("/pages/login.html").forward(req,resp);
        }else{
            req.getRequestDispatcher("/pages/Home_Page.html").forward(req,resp);
        }
    }
}
