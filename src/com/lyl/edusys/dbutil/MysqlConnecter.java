package com.lyl.edusys.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @program: Servlet02->Connecter
 * @description:
 * @author: qiuyu
 * @create: 2019-08-06 16:42
 **/
public class MysqlConnecter {
    public Connection getConnection() {
        try {
            ResourceBundle rb=ResourceBundle.getBundle("jdbcconfig");
            Class.forName(rb.getString("driver"));
            Connection connection = DriverManager.getConnection(rb.getString("url"),
                    rb.getString("usr"),
                    rb.getString("pwd"));
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
