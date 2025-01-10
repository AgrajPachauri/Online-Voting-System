package com.onlinevotingsystem.util;

import java.sql.Connection;

public class TestDBConnection {
    public static void main(String[] args) {
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            System.out.println("Database connection successful!");
        } else {
            System.out.println("Database connection failed.");
        }
    }
}
