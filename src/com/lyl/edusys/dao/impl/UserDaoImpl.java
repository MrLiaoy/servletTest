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
        connection=new MysqlConnecter().getConnection();
        String sql = "select * from sys_user where user_id=? and password=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getUser_id());
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
                        resultSet.getTime("create_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

