<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.Menu, java.util.List" %>
<%@ include file="navbar.jsp" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menu Page</title>
    <link rel="stylesheet" href="menu.css">
</head>
<body>

<div class="container">

    <!-- Display Restaurant Name -->
    <div class="restaurant-name">
        <%= session.getAttribute("restaurantName") %>
    </div>

    <!-- Menu Items -->
    <div>
        <% List<Menu> menuItems = (List<Menu>)session.getAttribute("menuItems");
        for(Menu menuItem : menuItems)
        { %>
            <div class="menu-item">
                <img src="<%= menuItem.getImgPath() %>" alt="<%= menuItem.getItemName() %>">
                <div class="menu-item-info">
                    <h2><%= menuItem.getItemName() %></h2>
                    <p><%= menuItem.getDescription() %></p>
                    <p class="price">₹<%= menuItem.getPrice() %></p>
                </div>
                <form action="cart">
                	<input type="hidden" name="menuId" value="<%= menuItem.getMenuId()%>">
                	Quantity:<input type="number" name="quantity" value="1" min="1">
                	<span class="customizable-text">Customizable</span>
                	<input type="submit" value="Add to cart">
                	<input type="hidden" name="action" value="add">
                </form>
            </div>
        <% } %>
    </div>
    
</div>

</body>
</html>
