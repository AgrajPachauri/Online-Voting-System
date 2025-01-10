package com.onlinevotingsystem.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect to a JSP for user profile or form
        request.getRequestDispatcher("/templates/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle form submission (registration or profile update)
        String action = request.getParameter("action");
        if ("register".equals(action)) {
            handleUserRegistration(request, response);
        }
    }

    private void handleUserRegistration(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Call UserDAO to store user details
        boolean isRegistered = false;
        try {
            isRegistered = UserDAO.registerUser(name, email, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isRegistered) {
            request.setAttribute("message", "Registration successful!");
        } else {
            request.setAttribute("message", "Registration failed. Try again.");
        }
        request.getRequestDispatcher("/templates/message.jsp").forward(request, response);
    }
}
