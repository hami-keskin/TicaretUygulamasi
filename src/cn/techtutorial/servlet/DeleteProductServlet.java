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
            // İstek parametrelerinden ürün ID'sini al
            int productId = Integer.parseInt(request.getParameter("id"));

            // ProductDao nesnesi oluştur ve ürünü sil
            ProductDao productDao = new ProductDao(DbCon.getConnection());
            boolean deleteSuccessful = productDao.deleteProduct(productId);

            if (deleteSuccessful) {
                // Ürün listesi sayfasına yönlendir veya başarı mesajını görüntüle
                response.sendRedirect("listProduct.jsp");
            } else {
                // Başarısızlık durumunda (örneğin, bir hata mesajı gösterme)
                response.getWriter().println("Ürün silme başarısız oldu.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Hata sayfasına yönlendir veya hata mesajını görüntüle
            response.sendRedirect("error.jsp");
        }
    }
}
