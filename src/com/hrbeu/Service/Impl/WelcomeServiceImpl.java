package com.hrbeu.Service.Impl;

import com.hrbeu.DAO.WelcomeDao;
import com.hrbeu.DAO.impl.WelcomeDaoImpl;
import com.hrbeu.Entity.New;
import com.hrbeu.Entity.User;
import com.hrbeu.Service.WelcomeService;

import java.util.List;

public class WelcomeServiceImpl implements WelcomeService {
    private WelcomeDao welcomeDao = new WelcomeDaoImpl();
    @Override
    public List<New> showNews(int page,int count,User user) {
        String isadmin = user.getIsadmin();
        List<New> news = null;
        switch (isadmin){
            case "Y":
                news = welcomeDao.selectNewsBypage_admin(page,count);
                break;
            case "N":
                news = welcomeDao.selectNewsBypage_user(page,count);
                break;
        }
        return news;
    }

    @Override
    public int getMaxPage(User user) {
        String isadmin = user.getIsadmin();
        int max_page=0;
        switch (isadmin){
            case "Y":
                max_page = welcomeDao.selectMaxPage_admin();
                break;
            case "N":
                max_page = welcomeDao.selectMaxPage_user();
                break;
        }
        return max_page;
    }
}
