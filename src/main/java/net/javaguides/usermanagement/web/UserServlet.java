package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.User;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	public void init() {
		userDAO = new UserDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		doGet(request, response);
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/login":
                    loginUser(request, response);
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
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int userID = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(userID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		User newUser = new User(userName, password);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException {
	    String idParam = request.getParameter("id");
	    if (idParam != null && !idParam.isEmpty()) {
	        int userID = Integer.parseInt(idParam);
	        String userName = request.getParameter("name");
	        String password = request.getParameter("password");

	        User user = new User(userID, userName, password);
	        userDAO.updateUser(user);
	    }
	    response.sendRedirect("list");
	}




	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int userID = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(userID);
		response.sendRedirect("list");

	}

    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        boolean isValidUser = userDAO.validateUser(userName, password);

        if (isValidUser) {
            // Kullanıcı doğrulandıysa ana sayfaya yönlendirme yapabilirsiniz
            response.sendRedirect("user-list.jsp");
        } else {
            // Kullanıcı doğrulanamadıysa hata mesajı ile giriş sayfasına yönlendirme yapabilirsiniz
            request.setAttribute("error", "Geçersiz kullanıcı adı veya parola");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }

}
