<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="cn.techtutorial.model.*, java.util.*" %>
<%@ include file="/includes/head.jsp" %>
<title>E-Commerce Cart</title>
</head>
<body>
    <% User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        response.sendRedirect("index.jsp");
    }
    %>
    <%@ include file="/includes/navbar.jsp" %>

    <div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center"><strong>Manager Panel</strong></div>
        <div class="card-body">
            <div class="text-center">
                <a href="listProduct.jsp" class="btn btn-primary">Product List</a>
                <a href="orderfollow.jsp" class="btn btn-primary">Order Follow</a>
                <a href="page3.jsp" class="btn btn-primary">Stock's</a>
            </div>
        </div>
    </div>
</div>


    <%@ include file="/includes/footer.jsp" %>
</body>
</html>
