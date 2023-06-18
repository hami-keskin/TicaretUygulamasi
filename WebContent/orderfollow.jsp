<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.techtutorial.dao.OrderDao" %>
<%@ page import="cn.techtutorial.connection.DbCon" %>
<%@ page import="cn.techtutorial.model.Order" %>
<%@ page import="java.sql.Connection" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Follow</title>
</head>
<body>
    <h1>Instant Orders</h1>
    
    <table>
        <tr>
            <th>Order ID</th>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Category</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Date</th>
        </tr>
        
        <% 
        // Establish a database connection
        Connection con = DbCon.getConnection();
        
        // Create an instance of OrderDao
        OrderDao orderDao = new OrderDao(con);
        
        // Retrieve the list of instant orders
        
        List<Order> instantOrders = orderDao.userOrders(3); // Pass the user ID
        
        // Iterate over the instant orders and generate table rows
        for (Order order : instantOrders) {
        %>
        <tr>
            <td><%= order.getOrderId() %></td>
            <td><%= order.getId() %></td>
            <td><%= order.getName() %></td>
            <td><%= order.getCategory() %></td>
            <td><%= order.getPrice() %></td>
            <td><%= order.getQunatity() %></td>
            <td><%= order.getDate() %></td>
        </tr>
        <% } %>
        
    </table>
    
</body>
</html> 