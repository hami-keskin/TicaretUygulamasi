package net.app.category;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryDAO categoryDAO;

    public void init() {
        categoryDAO = new CategoryDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/insert":
                    insertCategory(request, response);
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
                case "/insert":
                    insertCategory(request, response);
                    break;
                case "/delete":
                    deleteCategory(request, response);
                    break;
                case "/list":
                    listCategory(request, response);
                    break;
                default:
                    listCategory(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertCategory(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        String categoryName = request.getParameter("categoryName");
        Category newCategory = new Category(categoryName);
        categoryDAO.insertCategory(newCategory);
        response.sendRedirect(request.getContextPath() + "/list");
    }

    private void listCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Category> listCategory = categoryDAO.selectAllCategories();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("categoryList.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int categoryID = Integer.parseInt(request.getParameter("id"));
        categoryDAO.deleteCategory(categoryID);
        response.sendRedirect("list");
    }
}