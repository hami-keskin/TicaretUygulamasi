package cn.techtutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import cn.techtutorial.connection.DbCon;
import cn.techtutorial.dao.OrderDao;

@WebServlet("/cancel-order")
public class CancelOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()) {
            // Yazdırma işlemleri için PrintWriter kullanılıyor

            String id = request.getParameter("id"); // İstek parametresinden "id" değeri alınıyor
            if(id != null) { // Eğer "id" değeri boş değilse
                OrderDao orderDao = new OrderDao(DbCon.getConnection()); // OrderDao nesnesi oluşturuluyor ve veritabanı bağlantısı sağlanıyor
                orderDao.cancelOrder(Integer.parseInt(id)); // OrderDao üzerinden "cancelOrder" metodu çağrılıyor ve "id" değeri integer'a dönüştürülerek geçiliyor
            }
            response.sendRedirect("orders.jsp"); // Kullanıcıyı "orders.jsp" sayfasına yönlendiriyor
        } catch (ClassNotFoundException|SQLException e) {
            // Eğer bir hata veya istisna oluşursa, konsola hata mesajını yazdırıyor
            e.printStackTrace();
        } 
    }
}
