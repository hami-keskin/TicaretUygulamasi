<%@page import="cn.techtutorial.connection.DbCon"%>
<%@page import="cn.techtutorial.dao.ProductDao"%>
<%@page import="cn.techtutorial.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}
ProductDao pd = new ProductDao(DbCon.getConnection());
List<Product> products = pd.getAllProducts();
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/includes/head.jsp"%>
    <style>
        /* CSS for the sidebar */
        .sidebar {
            position: fixed;
            top: 0;
            left: 0;
            width: 200px;
            height: 100%;
            background-color: #f8f9fa;
            padding: 20px;
        }
        .sidebar ul {
            list-style-type: none;
            padding: 0;
        }
        .sidebar ul li {
            margin-bottom: 10px;
        }
        .sidebar ul li a {
            text-decoration: none;
            color: #000;
        }
        .sidebar ul li a.active {
            font-weight: bold;
        }
    </style>
    <title>E-Commerce Cart</title>
</head>
<body>
    <%@include file="/includes/navbar.jsp"%>

    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
            <div class="col-md-3 my-3">
                <div class="sidebar">
                    <!-- Sidebar content -->
                    <h4>Categories</h4>
                    <ul>
                        <% 
                        Map<String, List<Product>> categoryMap = new HashMap<>();

                        // Group products by category
                        for (Product p : products) {
                            String category = p.getCategory();
                            if (!categoryMap.containsKey(category)) {
                                categoryMap.put(category, new ArrayList<>());
                            }
                            categoryMap.get(category).add(p);
                        }

                        // Display categories in the sidebar
                        for (Map.Entry<String, List<Product>> entry : categoryMap.entrySet()) {
                            String category = entry.getKey();
                            List<Product> productList = entry.getValue();
                        %>
                        <li>
                            <a href="?category=<%= category %>">
                                <%= category %>
                                <% if (productList.size() > 1) { %>
                                (<%= productList.size() %>)
                                <% } %>
                            </a>
                        </li>
                        <% } %>
                    </ul>
                </div>
            </div>
            
            <div class="col-md-9">
                <div class="card-header my-3">All Products</div>
                <div class="row">
                    <% 
                    String selectedCategory = request.getParameter("category");

                    if (!products.isEmpty()) {
                        for (Product p : products) {
                            if (selectedCategory == null || selectedCategory.equals(p.getCategory())) {
                    %>
                    <div class="col-md-3 my-3">
                        <div class="card w-100">
                            <img class="card-img-top" src="product-image/<%=p.getImage() %>"
                                alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title"><%=p.getName() %></h5>
                                <h6 class="price">Price: $<%=p.getPrice() %></h6>
                                <h6 class="category">Category: <%=p.getCategory() %></h6>
                                <div class="mt-3 d-flex justify-content-between">
                                    <a class="btn btn-dark" href="add-to-cart?id=<%=p.getId()%>">Add to Cart</a>
                                    <a class="btn btn-primary" href="order-now?quantity=1&id=<%=p.getId()%>">Buy Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <% 
                            }
                        }
                    } else { 
                    %>
                    <div class="col-md-12">
                        <p>There are no products.</p>
                    </div>
                    <% 
                    } 
                    %>
                </div>
            </div>
        </div>
    </div>

    <%@include file="/includes/footer.jsp"%>
</body>
</html>







