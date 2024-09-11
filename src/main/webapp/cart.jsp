<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.Cart, java.util.List, java.util.Map, com.tap.model.CartItem" %>
<%@ include file="navbar.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>APPYPIE Food Delivery</title>
<link rel="stylesheet" href="cart.css">
</head>
<body>

<div class="cart-container">

    <h2>Your Cart</h2>
    
    <% Cart cart =(Cart) session.getAttribute("cart"); 
    if(cart != null && !cart.getItems().isEmpty()) {
        Map<Integer, CartItem> items = cart.getItems();
        for(Map.Entry<Integer, CartItem> item : items.entrySet()) { %>
            <div class="cart-item">
                <h4><%= item.getValue().getName() %></h4>
                <p>Price: ₹<%= item.getValue().getPrice() %></p>
                <p>Quantity: <%= item.getValue().getQuantity() %></p>
                <p>Subtotal: ₹<%= item.getValue().getSubTotal() %></p>
                <form action="cart" method="post" class="cart-form">
                    <input type="hidden" name="menuId" value="<%= item.getValue().getItemId()%>">
                    <label>Quantity:</label>
                    <input type="number" name="quantity" value="<%= item.getValue().getQuantity()%>" min="1">
                    <input type="submit" name="action" value="update" class="update-button">
                    <input type="submit" name="action" value="remove" class="remove-button">
                </form>
            </div>
    <% } %>

        <!-- Proceed to Checkout Button -->
        <div class="checkout">
            <form action="checkout.jsp" method="post">
                <input type="submit" value="Proceed to Checkout" class="checkout-button">
            </form>
        </div>

    <% } else { %>
        <p>Your cart is empty! Start adding some delicious food!  :)</p>
    <% } %>
</div>

</body>
</html>
