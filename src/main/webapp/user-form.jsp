<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Kullanıcı Yönetim Uygulaması</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
            <div>
                <a href="#" class="navbar-brand">Kullanıcı Yönetim Uygulaması</a>
            </div>
            <ul class="navbar-nav">
                <li><a href="${pageContext.request.contextPath}/list" class="nav-link">Kullanıcılar</a></li>
            </ul>
        </nav>
    </header>
    <br>
    <div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${user != null}">
                <form action="${pageContext.request.contextPath}/update" method="post">
            </c:if>
            <c:if test="${user == null}">
                <form action="${pageContext.request.contextPath}/insert" method="post">
            </c:if>


            <caption>
                <h2>
                    <c:if test="${user != null}">
                        Kullanıcıyı Düzenle
                    </c:if>
                    <c:if test="${user == null}">
                        Yeni Kullanıcı Ekle
                    </c:if>
                </h2>
            </caption>

            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.userID}' />" />
            </c:if>

            <fieldset class="form-group">
                <label>Kullanıcı Adı</label>
                <input type="text" value="<c:out value='${user.userName}' />" class="form-control" name="name" required="required">
            </fieldset>

            <fieldset class="form-group">
                <label>Parola</label>
                <input type="password" value="<c:out value='${user.password}' />" class="form-control" name="password" required="required">
            </fieldset>

            <button type="submit" class="btn btn-success">Kaydet</button>
        </div>
    	</div>
		</div>
</body>
</html>