package com.onlinevotingsystem.util;

import com.onlinevotingsystem.dao.UserDAO;
import com.onlinevotingsystem.model.User;

import java.util.List;

public class TestUserDAO {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Test adding a new user
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");
        if (userDAO.addUser(user)) {
            System.out.println("User added successfully!");
        } else {
            System.out.println("Failed to add user.");
        }

        // Test fetching all users
        List<User> users = userDAO.getAllUsers();
        System.out.println("All Users:");
        for (User u : users) {
            System.out.println(u);
        }

        // Test fetching a user by ID
        User fetchedUser = userDAO.getUserById(1); // Replace with a valid ID
        if (fetchedUser != null) {
            System.out.println("Fetched User: " + fetchedUser);
        } else {
            System.out.println("User not found.");
        }

        // Test updating a user
        user.setId(1); // Replace with a valid ID
        user.setName("Updated Name");
        user.setEmail("updated.email@example.com");
        if (userDAO.updateUser(user)) {
            System.out.println("User updated successfully!");
        } else {
            System.out.println("Failed to update user.");
        }

        // Test deleting a user
        if (userDAO.deleteUser(1)) { // Replace with a valid ID
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("Failed to delete user.");
        }
    }
}
