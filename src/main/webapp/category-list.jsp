<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
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
        <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

        <div class="container">
            <h3 class="text-center">List of Categories</h3>
            <hr>
            <div class="container text-left">

                <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
                    New Category</a>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Category ID</th>
                        <th>Category Name</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <!--   for (Todo todo: todos) {  -->
                    <c:forEach var="category" items="${listCategory}">

                        <tr>
                            <td><c:out value="${category.CategoryID}" /></td>
                            <td><c:out value="${category.CategoryName}" /></td>
                            <td><a href="edit?id=<c:out value='${category.CategoryID}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="delete?id=<c:out value='${category.CategoryID}' />">Delete</a></td>
                        </tr>
                    </c:forEach>
                    <!-- } -->
                </tbody>

            </table>
        </div>
    </div>
</body>
</html>
