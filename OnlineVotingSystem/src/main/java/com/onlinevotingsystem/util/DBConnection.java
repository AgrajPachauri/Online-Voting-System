package com.onlinevotingsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/online_voting_system?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC\"";
    private static final String USER = "custom_user";
    private static final String PASSWORD = "74568-Agraj";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
