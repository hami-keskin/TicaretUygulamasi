<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
</head>
<body>
    <h1>Edit Product</h1>
    <form action="update-product" method="post">
        <input type="hidden" name="id" value="${product.id}">
        <label for="name">Name:</label>
        <input type="text" name="name" value="${product.name}" required><br>
        <label for="category">Category:</label>
        <input type="text" name="category" value="${product.category}" required><br>
        <label for="price">Price:</label>
        <input type="number" name="price" value="${product.price}" required><br>
        <label for="image">Image:</label>
        <input type="text" name="image" value="${product.image}" required><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
