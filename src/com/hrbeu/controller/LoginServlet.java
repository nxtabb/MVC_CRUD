package com.hrbeu.controller;

import com.hrbeu.Entity.User;
import com.hrbeu.Service.Impl.LoginServiceImpl;
import com.hrbeu.Service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Pattern;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = loginService.login(username,password);
        if(user!=null){
            //登陆成功
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            //跳转
            resp.sendRedirect("/welcome");
        }
        else {
            String error1 = "用户名不存在或密码错误";
            req.setAttribute("error1",error1);
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
