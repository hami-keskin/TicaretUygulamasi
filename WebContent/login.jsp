<%@page import="cn.techtutorial.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
User auth = (User) request.getSession().getAttribute("auth");

// Kullanıcı oturumu açıksa, index.jsp sayfasına yönlendir
if (auth != null) {
    response.sendRedirect("index.jsp");
}

// Sepet listesini al
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

// Sepet listesi mevcutsa, request nesnesine ekle
if (cart_list != null) {
    request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>E-Commerce Cart</title>
</head>
<body>
    <%@include file="/includes/navbar.jsp"%>

    <div class="container">
        <div class="card w-50 mx-auto my-5">
            <div class="card-header text-center">Kullanıcı Girişi</div>
            <div class="card-body">
                <form action="user-login" method="post">
                    <div class="form-group">
                        <label>E-posta adresi</label> 
                        <input type="email" name="login-email" class="form-control" placeholder="E-posta adresini girin">
                    </div>
                    <div class="form-group">
                        <label>Şifre</label> 
                        <input type="password" name="login-password" class="form-control" placeholder="Şifre">
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Giriş Yap</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%@include file="/includes/footer.jsp"%>
</body>
</html>
