package com.hrbeu.DAO;

import com.hrbeu.Entity.New;

import java.util.List;

public interface WelcomeDao {
    List<New> selectNewsBypage_user(int page,int count);
    List<New> selectNewsBypage_admin(int page,int count);
    int selectMaxPage_admin();
    int selectMaxPage_user();
}
