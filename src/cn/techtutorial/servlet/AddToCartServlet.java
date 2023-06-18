package cn.techtutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import cn.techtutorial.model.*;


@WebServlet(name = "AddToCartServlet", urlPatterns = "/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // Yazdırma işlemleri için PrintWriter kullanılıyor
//             out.print("add to cart servlet");

            ArrayList<Cart> cartList = new ArrayList<>(); // Boş bir Cart listesi oluşturuluyor
            int id = Integer.parseInt(request.getParameter("id")); // İstek parametresinden "id" değeri alınıyor ve integer'a dönüştürülüyor
            Cart cm = new Cart(); // Yeni bir Cart örneği oluşturuluyor
            cm.setId(id); // Cart nesnesinin id değeri atanıyor
            cm.setQuantity(1); // Cart nesnesinin quantity değeri 1 olarak atanıyor
            HttpSession session = request.getSession(); // Mevcut session alınıyor
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list"); // Session'dan "cart-list" adlı öğe alınıyor ve bir ArrayList'e dönüştürülüyor

            if (cart_list == null) { // Eğer "cart-list" öğesi henüz tanımlanmamışsa
                cartList.add(cm); // Yeni Cart nesnesi cartList'e ekleniyor
                session.setAttribute("cart-list", cartList); // Cart listesi "cart-list" adıyla session'a ekleniyor
                response.sendRedirect("index.jsp"); // Kullanıcıyı "index.jsp" sayfasına yönlendiriyor
            } else { // Eğer "cart-list" öğesi tanımlıysa
                cartList = cart_list; // Var olan cart_list'i cartList'e atıyor

                boolean exist = false; // İlgili ürünün sepette olup olmadığını belirlemek için bir bayrak değişkeni tanımlanıyor
                for (Cart c : cart_list) { // cart_list üzerinde dönerek
                    if (c.getId() == id) { // Eğer ilgili ürünün id değeri mevcut ise
                        exist = true; // Bayrak değişkeni true olarak ayarlanıyor
                        out.println("<h3 style='color:crimson; text-align: center'>Sepette Zaten Bu Öğe Mevcut. <a href='cart.jsp'>Sepet Sayfasına Git</a></h3>"); // Kullanıcıya "Sepette Zaten Bu Öğe Mevcut" mesajı görüntüleniyor
                    }
                }

                if (!exist) { // Eğer bayrak değişkeni false ise (ürün sepete daha önce eklenmemişse)
                    cartList.add(cm); // Yeni Cart nesnesi cartList'e ekleniyor
                    response.sendRedirect("index.jsp"); // Kullanıcıyı "index.jsp" sayfasına yönlendiriyor
                }
            }
        }
    }
}
