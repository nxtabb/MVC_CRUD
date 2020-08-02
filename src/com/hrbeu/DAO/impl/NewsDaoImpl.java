package com.hrbeu.DAO.impl;

import com.hrbeu.DAO.NewsDao;
import com.hrbeu.Entity.New;
import com.hrbeu.Util.DBUtil;

import java.sql.*;

public class NewsDaoImpl implements NewsDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @Override
    public void addNews(String title, String author, String content) {
        connection = DBUtil.getConnection();
        String sql = "insert into news(title,author,pubdate,content,lockflag) values (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,author);
            preparedStatement.setDate(3,new Date(new java.util.Date().getTime()));
            preparedStatement.setString(4,content);
            preparedStatement.setInt(5,1);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,null);

    }

    @Override
    public New selectNewById(int id) {
        connection = DBUtil.getConnection();
        New new_sel = null;
        String sql = "select * from news where nid=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String title = resultSet.getString(2);
                String author = resultSet.getString(3);
                Date date = resultSet.getDate(4);
                String content = resultSet.getString(5);
                int lockflag = resultSet.getInt(6);
                new_sel = new New(id,title,author,date,content,lockflag);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return new_sel;

    }

    @Override
    public void updateNew(String title, String author, String content, java.util.Date pubdate, int lockflag,int id) {
        connection = DBUtil.getConnection();
        String sql = "update news set title=?,author=?,pubdate=?,content=?,lockflag=? where nid=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,author);
            preparedStatement.setDate(3,new Date(pubdate.getTime()));
            preparedStatement.setString(4,content);
            preparedStatement.setInt(5,lockflag);
            preparedStatement.setInt(6,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,null);
    }
}
