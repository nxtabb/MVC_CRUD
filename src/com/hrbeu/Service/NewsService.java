package com.hrbeu.Service;

import com.hrbeu.Entity.New;

public interface NewsService {
    void addNews(String title,String author,String content);
    New selectNewById(int id);
    void updateNew(String title, String author, String content,int lockflag,int id);
}
