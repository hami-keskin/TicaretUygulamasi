package cn.techtutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/log-out")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			if(request.getSession().getAttribute("auth")!=null) { // Oturumda "auth" özniteliği varsa
				request.getSession().removeAttribute("auth"); // "auth" özniteliğini oturumdan kaldır
				response.sendRedirect("login.jsp"); // login.jsp sayfasına yönlendir
			}else {
				response.sendRedirect("index.jsp"); // "auth" özniteliği yoksa index.jsp sayfasına yönlendir
			}

		} 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
