package com.hrbeu.Service.Impl;

import com.hrbeu.DAO.NewsDao;
import com.hrbeu.DAO.impl.NewsDaoImpl;
import com.hrbeu.Entity.New;
import com.hrbeu.Service.NewsService;

import java.util.Date;

public class NewsServiceImpl implements NewsService {
    private NewsDao newsDao = new NewsDaoImpl();
    @Override
    public void addNews(String title, String author, String content) {
        newsDao.addNews(title,author,content);
    }

    @Override
    public New selectNewById(int id) {
        return newsDao.selectNewById(id);
    }

    @Override
    public void updateNew(String title, String author, String content, int lockflag,int id) {
        Date pubdate = new Date();
        newsDao.updateNew(title,author,content,pubdate,lockflag,id);
    }

    @Override
    public void deleteNew(int id) {
        newsDao.deleteNew(id);
    }
}
