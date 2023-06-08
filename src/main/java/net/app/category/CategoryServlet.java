package net.app.category;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String categoryName = request.getParameter("categoryName");

        // Veritabanı bağlantısı için gerekli bilgileri ayarlayın
        String url = "jdbc:mysql://localhost:3306/e_commerce?user=root&serverTimezone=Europe/Istanbul";
        String username = "root";
        String password = "HKhk61+-";

        try {
            // JDBC sürücüsünü yükleyin
            Class.forName("com.mysql.jdbc.Driver");

            // Veritabanına bağlanın
            Connection conn = DriverManager.getConnection(url, username, password);

            // SQL sorgusunu hazırlayın
            String sql = "INSERT INTO kategori (kategori_adi) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, categoryName);

            // Sorguyu çalıştırın
            statement.executeUpdate();

            // Bağlantıyı kapatın
            conn.close();

            // Başarılı mesajını gösterin veya yönlendirme yapın
            response.sendRedirect("listCategory.jsp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
