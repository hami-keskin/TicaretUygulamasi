package cn.techtutorial.servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import cn.techtutorial.dao.ProductDao;
import cn.techtutorial.model.Product;
import cn.techtutorial.connection.DbCon;

import java.sql.Connection;

@WebServlet("/update-product")
public class UpdateProductServlet extends HttpServlet {

    private ProductDao productDao;

    public void init() {
        try {
            Connection connection = DbCon.getConnection();
            productDao = new ProductDao(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        if (idString != null && !idString.isEmpty()) {
            try {
                int id = Integer.parseInt(idString);
                Product product = productDao.getSingleProduct(id);
                request.setAttribute("product", product);
                request.getRequestDispatcher("editProduct.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.getWriter().println("Invalid ID format.");
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Failed to retrieve product: " + e.getMessage());
            }
        } else {
            response.getWriter().println("ID parameter is missing.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        if (idString == null || idString.isEmpty()) {
            response.getWriter().println("ID parameter is missing.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.getWriter().println("Invalid ID format.");
            return;
        }

        String name = request.getParameter("name");
        String category = request.getParameter("category");
        double price = 0.0;

        String priceString = request.getParameter("price");
        if (priceString != null && !priceString.isEmpty()) {
            try {
                price = Double.parseDouble(priceString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.getWriter().println("Invalid price format.");
                return;
            }
        }

        String image = request.getParameter("image");

        Product updatedProduct = new Product(id, name, category, price, image);
        try {
            boolean rowUpdated = productDao.updateProduct(updatedProduct);
            if (rowUpdated) {
                response.sendRedirect("listProduct.jsp");
            } else {
                response.getWriter().println("Failed to update product.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Failed to update product: " + e.getMessage());
        }
    }
}
