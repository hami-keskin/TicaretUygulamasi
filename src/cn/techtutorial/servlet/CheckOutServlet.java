package cn.techtutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import cn.techtutorial.connection.DbCon;
import cn.techtutorial.dao.OrderDao;
import cn.techtutorial.model.*;

@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            
            // PrintWriter kullanılarak yazdırma işlemleri yapılıyor

            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list"); // Oturumdan "cart-list" öğesi alınıyor ve ArrayList'e dönüştürülüyor
            User auth = (User) request.getSession().getAttribute("auth"); // Oturumdan "auth" öğesi alınıyor ve User sınıfına dönüştürülüyor
            
            if(cart_list != null && auth!=null) { // Eğer "cart_list" ve "auth" boş değilse
                for(Cart c:cart_list) { // cart_list üzerinde döngüye giriliyor
                    Order order = new Order(); // Order sınıfından bir nesne oluşturuluyor
                    order.setId(c.getId()); // Order nesnesine "id" değeri atanıyor
                    order.setUid(auth.getId()); // Order nesnesine "uid" değeri atanıyor
                    order.setQunatity(c.getQuantity()); // Order nesnesine "quantity" değeri atanıyor
                    order.setDate(formatter.format(date)); // Order nesnesine "date" değeri atanıyor
                    
                    OrderDao oDao = new OrderDao(DbCon.getConnection()); // OrderDao nesnesi oluşturuluyor ve veritabanı bağlantısı sağlanıyor
                    boolean result = oDao.insertOrder(order); // OrderDao üzerinden "insertOrder" metodu çağrılıyor ve "order" nesnesi geçiliyor
                    if(!result) break; // Eğer sonuç başarısız ise döngüden çıkılıyor
                }
                cart_list.clear(); // cart_list temizleniyor
                response.sendRedirect("orders.jsp"); // Kullanıcı "orders.jsp" sayfasına yönlendiriliyor
            }else {
                if(auth==null) { // Eğer oturumda kimlik doğrulama yapılmamışsa
                    response.sendRedirect("login.jsp"); // Kullanıcıyı "login.jsp" sayfasına yönlendiriyor
                }
                response.sendRedirect("cart.jsp"); // Kullanıcıyı "cart.jsp" sayfasına yönlendiriyor
            }
        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace(); // Eğer bir hata veya istisna oluşursa, konsola hata mesajını yazdırıyor
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
