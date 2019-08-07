package com.lyl.edusys.dao.impl;

import com.lyl.edusys.dao.UserDao;
import com.lyl.edusys.dbutil.MysqlConnecter;
import com.lyl.edusys.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {
    Connection connection = null;

    @Override
    public User queryByUserIDAndPassword(User user) {
        connection = MysqlConnecter.getConnection();
        String sql = "select * from sys_user where login_name=? and password=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getLogin_name());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
//          public User(int user_id, String name, String age, String sex, String hobby, String password, Date create_time) {
            if (resultSet.next()) {
                return new User(resultSet.getInt("user_id"),
                        resultSet.getString("name"),
                        resultSet.getString("age"),
                        resultSet.getString("sex"),
                        resultSet.getString("hobby"),
                        resultSet.getString("password"),
                        resultSet.getString("login_name"),
                        resultSet.getTime("create_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addUser(User user) {
        connection = MysqlConnecter.getConnection();
        String sql = "insert into sys_user(name,age,sex,hobby,login_name,password,create_time) values(?,?,?,?,?,?,sysdate())";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getAge());
            preparedStatement.setString(3, user.getSex());
            preparedStatement.setString(4, user.getHobby());
            preparedStatement.setString(5, user.getLogin_name());
            preparedStatement.setString(6, user.getPassword());

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<User> queryAll() {
        Connection connection = MysqlConnecter.getConnection();
        String sql = "select*from sys_user";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> userList = new ArrayList<User>();
            while (resultSet.next()) {
                User user = new User();
                int user_id = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");
                String sex = resultSet.getString("sex");
                String hobby = resultSet.getString("hobby");
                String login_name = resultSet.getString("login_name");
                String password = resultSet.getString("password");
                Date create_time = resultSet.getDate("create_time");
                user.setUser_id(user_id);
                user.setName(name);
                user.setAge(age);
                user.setSex(sex);
                user.setHobby(hobby);
                user.setLogin_name(login_name);
                user.setPassword(password);
                user.setCreate_time(create_time);
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteUserByUser_id(int user_id) {
        connection = MysqlConnecter.getConnection();
        String sql = "delete  from  sys_user where user_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateById(User user) {
        connection = MysqlConnecter.getConnection();
        String sql = "update sys_user set name=?,age=?,sex=?,hobby=?,login_name=?,password=? where user_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getAge());
            preparedStatement.setString(3, user.getSex());
            preparedStatement.setString(4, user.getHobby());
            preparedStatement.setString(5, user.getLogin_name());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setInt(7, user.getUser_id());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User queryById(int id) {
        connection = MysqlConnecter.getConnection();
        String sql = "select * from sys_user where user_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
//          public User(int user_id, String name, String age, String sex, String hobby, String password, Date create_time) {
            if (resultSet.next()) {
                return new User(resultSet.getInt("user_id"),
                        resultSet.getString("name"),
                        resultSet.getString("age"),
                        resultSet.getString("sex"),
                        resultSet.getString("hobby"),
                        resultSet.getString("password"),
                        resultSet.getString("login_name"),
                        resultSet.getTime("create_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

