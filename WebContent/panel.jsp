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
        <div class="card-header text-center"></div>
        <div class="card-body">
            <div class="text-center">
                <a href="page1.jsp" class="btn btn-primary">Button 1</a>
                <a href="page2.jsp" class="btn btn-primary">Button 2</a>
                <a href="page3.jsp" class="btn btn-primary">Button 3</a>
            </div>
        </div>
    </div>
</div>


    <%@ include file="/includes/footer.jsp" %>
</body>
</html>
