<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kayıt Ol</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
            <ul class="navbar-nav">
                <li><a href="${pageContext.request.contextPath}/list" class="nav-link">Kullanıcılar</a></li>
            </ul>
        </nav>
    </header>
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body"> 

            
<script>
    function setAction(action) {
        var form = document.getElementById("form");
        form.action = "${pageContext.request.contextPath}/" + action;
    }
</script>

<form id="form" method="post">
                    <fieldset class="form-group">
                        <label for="userName">Kullanıcı Adı:</label>
                        <input type="text" id="userName" name="userName" class="form-control" required><br>
                    </fieldset>
                    <fieldset class="form-group">
                        <label for="password">Parola:</label>
                        <input type="password" id="password" name="password" class="form-control" required><br>
                    </fieldset>
                    <button type="submit" class="btn btn-primary" onclick="setAction('insert')">Kayıt Ol</button>
    <button type="submit" class="btn btn-success" onclick="setAction('login')">Giriş Yap</button>
</form>

            </div>
        </div>
    </div>
</body>
</html>
