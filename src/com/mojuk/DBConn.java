package com.mojuk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
* Sington 관리
* */
public class DBConn {
    private static DBConn instance = null;
    private static Connection conn;

    private DBConn(){
            String url = "jdbc:mysql://localhost:3306/mojuk?serverTimezone=UTC";
            String user = "root";
            String password = "1234";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public static DBConn getInstance(){
        if(instance == null)
            return new DBConn();
        else return instance;
    }

    public static Connection getConnection() {
        return conn;
    }

}
