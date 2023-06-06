<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Yönetim Girişi</title>
    <style>
        body {
            background-color: #f5f5f5;
            font-family: Arial, sans-serif;
            padding: 20px;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        form {
            display: inline-block;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="password"] {
            padding: 10px;
            width: 200px;
            border: 1px solid #ccc;
            border-radius: 5px;
            outline: none;
        }

        button[type="submit"] {
            padding: 10px 20px;
            margin-top: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
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
