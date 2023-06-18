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
            String name = request.getParameter("name"); // "name" parametresinin değerini al
            String category = request.getParameter("category"); // "category" parametresinin değerini al
            double price = Double.parseDouble(request.getParameter("price")); // "price" parametresinin değerini alıp double'a çevir
            String image = request.getParameter("image"); // "image" parametresinin değerini al

            // Sağlanan bilgilerle yeni bir Product nesnesi oluştur
            Product product = new Product(); // Product sınıfının yeni bir örneğini oluştur
            product.setName(name); // Ürünün adını ayarla
            product.setCategory(category); // Ürünün kategorisini ayarla
            product.setPrice(price); // Ürünün fiyatını ayarla
            product.setImage(image); // Ürünün resim URL'sini ayarla

            // Bir ProductDao oluştur ve ürünü ekle
            ProductDao productDao = new ProductDao(DbCon.getConnection()); // Veritabanı bağlantısını geçerek yeni bir ProductDao örneği oluştur
            boolean addSuccessful = productDao.addProduct(product); // ProductDao kullanarak ürünü ekle

            if (addSuccessful) {
                // listProduct sayfasına yönlendir 
                response.sendRedirect("listProduct.jsp"); // Ürün başarıyla eklendiyse kullanıcıyı "listProduct.jsp" sayfasına yönlendir
            } else {
                // Hata sayfasına yönlendir veya hata mesajını görüntüle
                response.sendRedirect("error.jsp"); // Ürün eklenirken bir hata oluştuysa kullanıcıyı "error.jsp" sayfasına yönlendir
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Hata sayfasına yönlendir veya hata mesajını görüntüle
            response.sendRedirect("error.jsp"); // Bir istisna veya hata oluştuysa kullanıcıyı "error.jsp" sayfasına yönlendir
        }
    }
}
