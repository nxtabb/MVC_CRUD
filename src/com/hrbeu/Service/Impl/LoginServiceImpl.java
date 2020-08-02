package com.hrbeu.Service.Impl;

import com.hrbeu.DAO.LoginDao;
import com.hrbeu.DAO.impl.LoginDaoImpl;
import com.hrbeu.Entity.User;
import com.hrbeu.Service.LoginService;

public class LoginServiceImpl implements LoginService {
    private LoginDao loginDao = new LoginDaoImpl();
    @Override
    public User login(String username, String password) {
        User user = loginDao.login(username, password);
        return user;
    }
}
