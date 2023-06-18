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
            // İstek parametrelerinden ürün bilgisini al
            String name = request.getParameter("name");
            String category = request.getParameter("category");
            double price = Double.parseDouble(request.getParameter("price"));
            String image = request.getParameter("image");

            // Sağlanan bilgilerle yeni bir Product nesnesi oluştur
            Product product = new Product();
            product.setName(name);
            product.setCategory(category);
            product.setPrice(price);
            product.setImage(image);

            // Bir ProductDao oluştur ve ürünü ekle
            ProductDao productDao = new ProductDao(DbCon.getConnection());
            boolean addSuccessful = productDao.addProduct(product);

            if (addSuccessful) {
                // Başarı sayfasına yönlendir veya başarı mesajını görüntüle
                response.sendRedirect("listProduct.jsp");
            } else {
                // Hata sayfasına yönlendir veya hata mesajını görüntüle
                response.sendRedirect("error.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Hata sayfasına yönlendir veya hata mesajını görüntüle
            response.sendRedirect("error.jsp");
        }
    }
}
