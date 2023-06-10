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
import cn.techtutorial.model.Product;

@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            // Retrieve the product information from the request parameters
            String name = request.getParameter("name");
            String category = request.getParameter("category");
            double price = Double.parseDouble(request.getParameter("price"));
            String image = request.getParameter("image");

            // Create a new Product object with the provided information
            Product product = new Product();
            product.setName(name);
            product.setCategory(category);
            product.setPrice(price);
            product.setImage(image);

            // Create a ProductDao and add the product
            ProductDao productDao = new ProductDao(DbCon.getConnection());
            boolean addSuccessful = productDao.addProduct(product);

            if (addSuccessful) {
                // Redirect to a success page or display a success message
                response.sendRedirect("success.jsp");
            } else {
                // Redirect to an error page or display an error message
                response.sendRedirect("error.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Redirect to an error page or display an error message
            response.sendRedirect("error.jsp");
        }
    }
}
