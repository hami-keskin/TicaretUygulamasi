<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="cn.techtutorial.model.*, java.util.*" %>
<%@ include file="/includes/head.jsp" %>
<title>E-Commerce Cart</title>
</head>
<body>
    <% User auth = (User) request.getSession().getAttribute("auth");

    // Kullanıcı oturumu açıksa, index.jsp sayfasına yönlendir
    if (auth != null) {
        response.sendRedirect("index.jsp");
    }
    %>
    <%@ include file="/includes/navbar.jsp" %>

    <div class="container">
        <div class="card w-50 mx-auto my-5">
            <div class="card-header text-center">Giriş</div>
            <div class="card-body">
                <form action="ManagerLoginServlet" method="post">
                    <div class="form-group">
                        <label>Şifre</label>
                        <input type="password" name="login-password" class="form-control" placeholder="Şifre">
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Giriş Yap</button>
                    </div>
                </form>
                <% String error = (String) request.getAttribute("error");

                // Hata varsa, hata mesajını görüntüle
                if (error != null) {
                %>
                <div class="alert alert-danger mt-3">
                    <%= error %>
                </div>
                <% } %>
            </div>
        </div>
    </div>

    <%@ include file="/includes/footer.jsp" %>
</body>
</html>
