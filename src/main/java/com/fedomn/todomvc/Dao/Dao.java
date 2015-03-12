package com.fedomn.todomvc.Dao;


import java.sql.*;

public class Dao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/todos?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "Mn1234567";
    Connection conn = getConnection();
    PreparedStatement preparedStatement;

    private Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close() throws SQLException {
        if (preparedStatement != null)
            preparedStatement.close();
        if (conn != null)
            conn.close();
    }

}
