<%@page import="com.tap.daoimpls.MenuDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tap.model.OrderItem, com.tap.model.Menu, com.tap.daoimpls.MenuDAOImpl" %>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Details</title>
    <link rel="stylesheet" type="text/css" href="orderdetails.css">
</head>
<body>

<form action="orderhistory.jsp" class="back-btn-container">
    <button type="submit" class="back-btn">Back</button>
</form>

<div class="order-details-container">
    <% List<OrderItem> orderhistoryItems = (List<OrderItem>) session.getAttribute("orderDetails");
    MenuDAOImpl mdaoi = new MenuDAOImpl();
    for(OrderItem orderitem : orderhistoryItems) { 
    	Menu menuitem = mdaoi.getMenuItem(orderitem.getMenuId()); %>
        <div class="order-item">
            <div class="order-image">
                <img alt="<%= menuitem.getItemName() %>" src="<%= menuitem.getImgPath() %>" />
            </div>
            <div class="order-info">
                <h2><%= menuitem.getItemName() %></h2>
                <p>Order ID: <%= orderitem.getOrderId() %></p>
                <p>Quantity: <%= orderitem.getQuantity() %></p>
                <p>Subtotal: ₹<%= orderitem.getSubTotal() %></p>
            </div>
        </div>
    <% } %>
</div>

</body>
</html>
