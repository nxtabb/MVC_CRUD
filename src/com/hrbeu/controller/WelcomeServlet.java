package com.hrbeu.controller;

import com.hrbeu.Entity.New;
import com.hrbeu.Entity.User;
import com.hrbeu.Service.Impl.WelcomeServiceImpl;
import com.hrbeu.Service.WelcomeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    private WelcomeService welcomeService = new WelcomeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("page");
        if(pageStr==null){
            pageStr="1";
        }
        int page = Integer.parseInt(pageStr);
        HttpSession session = req.getSession();
        User user = null;
        user = (User)session.getAttribute("user");
        List<New> news = null;
        news = welcomeService.showNews(page,5,user);
        int count = welcomeService.getMaxPage(user);
        req.setAttribute("count",count);
        req.setAttribute("news",news);
        req.setAttribute("pageno",page);
        req.getRequestDispatcher("welcome.jsp").forward(req,resp);
    }
}
