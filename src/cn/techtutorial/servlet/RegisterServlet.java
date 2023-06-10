package cn.techtutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import cn.techtutorial.connection.DbCon;
import cn.techtutorial.dao.UserDao;
import cn.techtutorial.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // Create a new User object with the provided information
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);

            // Create a UserDao and register the user
            UserDao userDao = new UserDao(DbCon.getConnection());
            boolean registrationSuccessful = userDao.registerUser(user);

            if (registrationSuccessful) {
                out.println("Registration successful!");
                // Redirect to login page or any other desired page
                response.sendRedirect("login.jsp");
            } else {
                out.println("Registration failed!");
                // Display an error message or handle the failure appropriately
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
