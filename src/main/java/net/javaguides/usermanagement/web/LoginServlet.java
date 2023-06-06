package net.javaguides.usermanagement.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Sabit olarak tanımlanmış bir şifre
	private static final String PASSWORD = "1234";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Formdan gelen şifreyi al
		String password = request.getParameter("password");

		// Şifreyi kontrol et
		if (password.equals(PASSWORD)) {
			// Şifre doğruysa success.jsp sayfasına yönlendir
			response.sendRedirect("success.jsp");
		} else {
			// Şifre yanlışsa error.jsp sayfasına yönlendir
			response.sendRedirect("error.jsp");
		}

	}
}
