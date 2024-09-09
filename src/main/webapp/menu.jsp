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
        for(Menu menu : menuItems)
        { %>
            <div class="menu-item">
                <img src="<%= menu.getImgPath() %>" alt="<%= menu.getItemName() %>">
                <div class="menu-item-info">
                    <h2><%= menu.getItemName() %></h2>
                    <p><%= menu.getDescription() %></p>
                    <p class="price">₹<%= menu.getPrice() %></p>
                    <p class="customisable">Customisable</p>
                </div>
                <a href=""><button class="add-button">ADD</button></a>
            </div>
        <% } %>
    </div>
    
</div>

</body>
</html>
