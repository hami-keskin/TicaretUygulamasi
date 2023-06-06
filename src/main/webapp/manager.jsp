<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Yönetim Girişi</title>
</head>
<body>
    <h1>Yönetim Girişi</h1>
    <form method="post" action="LoginServlet">
        <label for="password">Şifre:</label>
        <input type="password" id="password" name="password" required><br>
        <button type="submit">Giriş Yap</button>
    </form>
</body>
</html>
