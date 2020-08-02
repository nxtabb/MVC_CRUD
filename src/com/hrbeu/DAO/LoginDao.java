package com.hrbeu.DAO;

import com.hrbeu.Entity.User;

public interface LoginDao {
    User login(String username,String password);
}
