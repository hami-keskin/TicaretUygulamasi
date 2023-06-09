<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kayıt - Giriş</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
            <ul class="navbar-nav">
                <li><a href="${pageContext.request.contextPath}/listUser" class="nav-link">Kullanıcılar</a></li>
            </ul>
        </nav>
    </header>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card mt-5">
                    <div class="card-body">
                        <form id="form" method="post" action="${pageContext.request.contextPath}/insertUser">
                            <div class="form-group">
                                <label for="userName">Kullanıcı Adı:</label>
                                <input type="text" id="userName" name="userName" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Parola:</label>
                                <input type="password" id="password" name="password" class="form-control" required>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Kayıt Ol</button>
                                <button type="submit" class="btn btn-success" onclick="setAction('login')">Giriş Yap</button>
                            </div>
                            <% String error = (String) request.getAttribute("error");
                               if (error != null) { %>
                               <div class="alert alert-danger mt-3">
                                   <%= error %>
                               </div>
                            <% } %>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        function setAction(action) {
            var form = document.getElementById("form");
            form.action = "${pageContext.request.contextPath}/" + action;
        }
    </script>
</body>
</html>
