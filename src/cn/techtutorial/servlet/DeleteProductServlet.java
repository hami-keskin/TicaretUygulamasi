package cn.techtutorial.servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import cn.techtutorial.connection.DbCon;
import cn.techtutorial.dao.ProductDao;

@WebServlet("/delete-product")
public class DeleteProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            // Retrieve the product ID from the request parameters
            int productId = Integer.parseInt(request.getParameter("id"));

            // Create a ProductDao and delete the product
            ProductDao productDao = new ProductDao(DbCon.getConnection());
            boolean deleteSuccessful = productDao.deleteProduct(productId);

            if (deleteSuccessful) {
                // Redirect to the product list page or show a success message
                response.sendRedirect("listProduct.jsp");
            } else {
                // Handle the failure case (e.g., show an error message)
                response.getWriter().println("Failed to delete product.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Redirect to an error page or display an error message
            response.sendRedirect("error.jsp");
        }
    }
}
