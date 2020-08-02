package com.hrbeu.DAO.impl;

import com.hrbeu.DAO.LoginDao;
import com.hrbeu.Entity.User;
import com.hrbeu.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @Override
    public User login(String username, String password) {
        connection = DBUtil.getConnection();
        String sql = "select * from user where username=? and password=?";
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String username_sel = resultSet.getString(1);
                String password_sel = resultSet.getString(2);
                String isadmin = resultSet.getString(3);
                user = new User(username_sel,password_sel,isadmin);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return user;
    }
}
