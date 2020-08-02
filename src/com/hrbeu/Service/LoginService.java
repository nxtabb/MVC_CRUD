package com.hrbeu.Service;

import com.hrbeu.Entity.User;

public interface LoginService {
    User login(String username, String password);
}
