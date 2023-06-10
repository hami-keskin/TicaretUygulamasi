<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="cn.techtutorial.model.Product" %>
<%@ page import="cn.techtutorial.dao.ProductDao" %>
<%@ page import="cn.techtutorial.connection.DbCon" %>

<!DOCTYPE html>
<html>
<head>
    <%@include file="/includes/head.jsp"%>
    <title>Add Product</title>
</head>
<body>

    <div class="container">
        <div class="card w-50 mx-auto my-5">
            <div class="card-header text-center">Add Product</div>
            <div class="card-body">
                <form method="post" action="add-product">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" id="name" name="name" class="form-control" placeholder="Enter the product name">
                    </div>

                    <div class="form-group">
                        <label for="category">Category:</label>
                        <input type="text" id="category" name="category" class="form-control" placeholder="Enter the product category">
                    </div>

                    <div class="form-group">
                        <label for="price">Price:</label>
                        <input type="text" id="price" name="price" class="form-control" placeholder="Enter the product price">
                    </div>

                    <div class="form-group">
                        <label for="image">Image URL:</label>
                        <input type="text" id="image" name="image" class="form-control" placeholder="Enter the image URL">
                    </div>

                    <div class="text-center">
                        <input type="submit" value="Add Product" class="btn btn-primary">
                    </div>
                </form>

                <div class="text-center mt-3">
                    <div class="btn-group">
                        <button class="btn btn-secondary" onclick="history.back()">Go Back</button>
                        <div class="btn-group__space"></div>
                        <button class="btn btn-secondary" onclick="goToPanel()">Go to Panel</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@include file="/includes/footer.jsp"%>

    <script>
        function goToPanel() {
            window.location.href = "panel.jsp";
        }
    </script>
</body>
</html>
