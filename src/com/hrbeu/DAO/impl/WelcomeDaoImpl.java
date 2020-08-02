package com.hrbeu.DAO.impl;

import com.hrbeu.DAO.WelcomeDao;
import com.hrbeu.Entity.New;
import com.hrbeu.Entity.User;
import com.hrbeu.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WelcomeDaoImpl implements WelcomeDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @Override
    public List<New> selectNewsBypage_user(int page, int count) {
        connection = DBUtil.getConnection();
        String sql = "select * from news where lockflag=0 limit ?,?";
        List<New> news = new ArrayList<New>();
        New new_sel = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,(count*page-count));
            preparedStatement.setInt(2,count);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int nid  = resultSet.getInt(1);
                String tittle = resultSet.getString(2);
                String author = resultSet.getString(3);
                Date pubdate = (Date)resultSet.getDate(4);
                String content = resultSet.getString(5);
                int lockflag = resultSet.getInt(6);
                new_sel = new New(nid,tittle,author,pubdate,content,lockflag);
                news.add(new_sel);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return news;

    }

    @Override
    public List<New> selectNewsBypage_admin(int page, int count) {
        connection = DBUtil.getConnection();
        String sql = "select * from news limit ?,?";
        List<New> news = new ArrayList<New>();
        New new_sel = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,(count*page-count));
            preparedStatement.setInt(2,count);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int nid  = resultSet.getInt(1);
                String tittle = resultSet.getString(2);
                String author = resultSet.getString(3);
                Date pubdate = (Date)resultSet.getDate(4);
                String content = resultSet.getString(5);
                int lockflag = resultSet.getInt(6);
                new_sel = new New(nid,tittle,author,pubdate,content,lockflag);
                news.add(new_sel);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return news;
    }

    @Override
    public int selectMaxPage_admin() {
        connection = DBUtil.getConnection();
        String sql = "select count(*) from news";
        int max_page = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                max_page  = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return max_page;
    }

    @Override
    public int selectMaxPage_user() {
        connection = DBUtil.getConnection();
        String sql = "select count(*) from news where lockflag=0 ";
        int max_page = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                max_page  = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return max_page;
    }
}
