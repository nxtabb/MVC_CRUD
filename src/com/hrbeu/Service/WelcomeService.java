package com.hrbeu.Service;

import com.hrbeu.Entity.New;
import com.hrbeu.Entity.User;

import java.util.List;

public interface WelcomeService {
    List<New> showNews(int page,int count,User user);
    int getMaxPage(User user);
}
