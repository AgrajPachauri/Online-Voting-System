package com.onlinevotingsystem.test;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.onlinevotingsystem.dao.UserDAO;
import com.onlinevotingsystem.util.DBConnection;

public class UserDAOTest {
    @BeforeClass
    public static void setup() {
        try {
            Connection connection = DBConnection.getConnection();
            assertTrue("Database connection should be established.", connection != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegisterUser() {
        try {
            boolean isRegistered = UserDAO.registerUser("Test User", "test@example.com", "password123");
            assertTrue("User should be registered successfully.", isRegistered);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
