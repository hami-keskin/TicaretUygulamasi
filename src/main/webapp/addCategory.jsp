<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Kategori Yönetimi Uygulaması</title>
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
                <a href="https://www.javaguides.net" class="navbar-brand"> Kategori Yönetim Uygulaması </a>
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/categoryList.jsp"
                    class="nav-link">Kategoriler</a></li>
            </ul>
        </nav>
    </header>
    <br>
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <form action="insert" method="post">

                    <caption>
                        <h2>Kategori Ekle</h2>
                    </caption>

                    <fieldset class="form-group">
                        <label>Kategori Adı</label> <input type="text"
                            class="form-control"
                            name="categoryName" required="required">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Kaydet</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
