/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cn.techtutorial.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Sabit olarak tanımlanmış bir şifre
	private static final String PASSWORD = "1234";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Formdan gelen şifreyi al
		String password = request.getParameter("login-password");

		// Şifreyi kontrol et
		if (password != null && password.equals(PASSWORD)) {
			// Şifre doğruysa success.jsp sayfasına yönlendir
			response.sendRedirect("panel.jsp");
		} else {
			// Şifre yanlışsa error mesajını request özniteliğine ekle ve manager.jsp sayfasına yönlendir
			request.setAttribute("error", "Wrong!");
			request.getRequestDispatcher("manager.jsp").forward(request, response);
		}

	}
}