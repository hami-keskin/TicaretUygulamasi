<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giriş Yap</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <h1>Giriş Yap</h1>
    <form action="login" method="post">
        <label for="userName">Kullanıcı Adı:</label>
        <input type="text" id="userName" name="userName" required><br>
        <label for="password">Parola:</label>
        <input type="password" id="password" name="password" required><br>
        <button type="submit">Giriş Yap</button>
    </form>
</body>
</html>