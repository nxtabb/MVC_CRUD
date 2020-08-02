package com.hrbeu.controller;

import com.hrbeu.Entity.New;
import com.hrbeu.Service.Impl.NewsServiceImpl;
import com.hrbeu.Service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/crudnews")
public class NewsServlet extends HttpServlet {
    private NewsService newsService = new NewsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "add":
                resp.sendRedirect("add.jsp");
                break;
            case "update":
                String nidStr = req.getParameter("id");
                int nid = Integer.parseInt(nidStr);
                New new_sel = newsService.selectNewById(nid);
                req.setAttribute("new1",new_sel);
                req.getRequestDispatcher("update.jsp").forward(req,resp);
            case "delete":
                String idStr = req.getParameter("id");
                int id = Integer.parseInt(idStr);
                newsService.deleteNew(id);
                resp.sendRedirect("/welcome");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "add":
                String title = req.getParameter("title");
                String author = req.getParameter("author");
                String content = req.getParameter("content");
                newsService.addNews(title,author,content);
                resp.sendRedirect("/welcome");
                break;
            case "update":
                String idStr = req.getParameter("id");
                int id = Integer.parseInt(idStr);
                title = req.getParameter("title");
                author = req.getParameter("author");
                content = req.getParameter("content");
                int lockflag = Integer.parseInt(req.getParameter("lockflag"));
                newsService.updateNew(title,author,content,lockflag,id);
                resp.sendRedirect("/welcome");
                break;

        }
    }
}
