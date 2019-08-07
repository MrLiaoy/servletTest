package com.lyl.edusys.dao.impl;

import com.lyl.edusys.dao.UserDao;
import com.lyl.edusys.dbutil.MysqlConnecter;
import com.lyl.edusys.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    Connection connection=null;
    @Override
    public User queryByUserIDAndPassword(User user) {
        connection=MysqlConnecter.getConnection();
        String sql = "select * from sys_user where login_name=? and password=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getLogin_name());
            preparedStatement.setString(2,user.getPassword());
            ResultSet resultSet=preparedStatement.executeQuery();
//          public User(int user_id, String name, String age, String sex, String hobby, String password, Date create_time) {
            if (resultSet.next()){
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
        String sql="insert into sys_user(name,age,sex,hobby,login_name,password,create_time) values(?,?,?,?,?,?,sysdate())";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getAge());
            preparedStatement.setString(3,user.getSex());
            preparedStatement.setString(4,user.getHobby());
            preparedStatement.setString(5,user.getLogin_name());
            preparedStatement.setString(6,user.getPassword());

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}

