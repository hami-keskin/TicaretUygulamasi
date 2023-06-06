<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Kullanıcı Yönetim Uygulaması</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>

    <header>
        <nav class="navbar navbar-expand-md navbar-dark"
            style="background-color: tomato">
            <div>
                <a href="https://www.javaguides.net" class="navbar-brand"> Kullanıcı
                    Yönetim Uygulaması </a>
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/list"
                    class="nav-link">Kullanıcılar</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">
        <div class="container">
            <h3 class="text-center">Kategori Listesi</h3>
            <hr>
            <div class="container text-left">
                <a href="<%=request.getContextPath()%>/addCategory.jsp" class="btn btn-success">Yeni Kategori Ekle</a>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Kategori ID</th>
                        <th>Kategori Adı</th>
                        <th>İşlemler</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="category" items="${listCategory}">
                        <tr>
                            <td><c:out value="${category.CategoryID}" /></td>
                            <td><c:out value="${category.CategoryName}" /></td>
                            <td>
                                <a href="edit?id=<c:out value='${category.CategoryID}' />">Düzenle</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="delete?id=<c:out value='${category.CategoryID}' />">Sil</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
