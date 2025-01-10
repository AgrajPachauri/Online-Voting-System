package com.onlinevotingsystem.test;

import com.onlinevotingsystem.dao.UserDAO;
import com.onlinevotingsystem.model.User;

public class TestUserRegistration {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        User user = new User(0, "john_doe", "password123", "john.doe@example.com", "voter");

        boolean isRegistered = userDAO.registerUser(user);
        if (isRegistered) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("User registration failed.");
        }
    }
}
