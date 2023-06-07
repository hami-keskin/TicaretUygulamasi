package net.app.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
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
			response.sendRedirect("managerPanel.jsp");
		} else {
			// Şifre yanlışsa error mesajını request özniteliğine ekle ve manager.jsp sayfasına yönlendir
			request.setAttribute("error", "Hatalı şifre!");
			request.getRequestDispatcher("managerLogin.jsp").forward(request, response);
		}

	}
}