/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ticaret_uygulamasi.ticaret_uygulamasi.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/login":
                    loginUser(request, response);
                    break;
                case "/insertUser":
                	insertUser(request, response);
                    break;
                default:
                    // Diğer case'ler...
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/insertUser":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/list":
                    listUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User newUser = new User(userName, password);
        userDAO.insertUser(newUser);
        response.sendRedirect(request.getContextPath() + "/list");
    }

    
    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");

    boolean isValidUser = userDAO.validateUser(userName, password);

    if (isValidUser) {
        // Kullanıcı doğrulandıysa ana sayfaya yönlendirme yapabilirsiniz
    	response.sendRedirect(request.getContextPath() + "/list");
    } else {
        // Kullanıcı doğrulanamadıysa hata mesajı ile giriş sayfasına yönlendirme yapabilirsiniz
        request.setAttribute("error", "Geçersiz kullanıcı adı veya parola");
        RequestDispatcher dispatcher = request.getRequestDispatcher("userLogin.jsp");
        dispatcher.forward(request, response);
    }
}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("userList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int userID = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(userID);
		response.sendRedirect("list");

	}
}
