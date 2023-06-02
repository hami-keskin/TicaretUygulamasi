<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giriş Yap</title>
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
