package com.hrbeu.DAO;

import com.hrbeu.Entity.New;

import java.util.Date;

public interface NewsDao {
    void addNews(String title,String author,String content);
    New selectNewById(int id);
    void updateNew(String title, String author, String content, Date pubdate, int lockflag,int id);
}
