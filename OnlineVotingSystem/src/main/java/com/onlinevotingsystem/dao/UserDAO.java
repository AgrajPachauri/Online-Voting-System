package com.onlinevotingsystem.dao;

import com.onlinevotingsystem.model.User;
import com.onlinevotingsystem.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Insert a new user
    public boolean addUser(User user) {
        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Fetch all users
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public static boolean registerUser(String name, String email, String password) throws Exception {
        boolean isRegistered = false;
        Connection conn = DBConnection.getConnection();

        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                isRegistered = true;
            }
        }
        return isRegistered;
    }

    // Fetch a user by ID
    public User getUserById(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update user details
    public boolean updateUser(User user) {
        String query = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";
        try (Connection  connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
               preparedStatement.setString(1, user.getName());
               preparedStatement.setString(2, user.getEmail());
               preparedStatement.setString(3, user.getPassword());
               preparedStatement.setInt(4, user.getId());
               return preparedStatement.executeUpdate() > 0;
           } catch (SQLException e) {
               e.printStackTrace();
           }
           return false;
       }

       // Delete a user
       public boolean deleteUser(int id) {
           String query = "DELETE FROM users WHERE id = ?";
           try (Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
               preparedStatement.setInt(1, id);
               return preparedStatement.executeUpdate() > 0;
           } catch (SQLException e) {
               e.printStackTrace();
           }
           return false;
       }
   }
