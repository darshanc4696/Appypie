<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.Cart,java.util.Map, com.tap.model.CartItem"%>
<%@ include file="navbar.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout Page</title>
<!-- Link to external CSS -->
<link rel="stylesheet" href="checkout.css">
</head>
<body>

<div class="checkout-container">
    <h2>Checkout Summary</h2>

    <% Cart cart = (Cart) session.getAttribute("cart"); 

    if (cart != null && !cart.getItems().isEmpty()) { 
        Map<Integer, CartItem> items = cart.getItems();
    %>
        <table>
            <thead>
                <tr>
                    <th>Item Name</th>
                    <th>Price (₹)</th>
                    <th>Quantity</th>
                    <th>Subtotal (₹)</th>
                </tr>
            </thead>
            <tbody>
                <% 
                for (Map.Entry<Integer, CartItem> item : items.entrySet()) { 
                    CartItem cartItem = item.getValue(); 
                %>
                    <tr>
                        <td><%= cartItem.getName() %></td>
                        <td>₹<%= cartItem.getPrice() %></td>
                        <td><%= cartItem.getQuantity() %></td>
                        <td>₹<%= cartItem.getSubTotal() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>

        <!-- Total Amount -->
        <div class="total-container">
            Total: ₹<%= cart.getTotal() %>
        </div>

        <!-- Payment Section -->
        <div class="payment-section">
            <form action="orderconfirmed.jsp" method="post">
                <label for="payment-method">Select Payment Method:</label>
                <select name="paymentMethod" id="payment-method" required>
                    <option value="" disabled selected>Select your option</option>
                    <option value="credit-card">Credit Card</option>
                    <option value="debit-card">Debit Card</option>
                    <option value="upi">UPI</option>
                    <option value="net-banking">Net Banking</option>
                    <option value="cash-on-delivery">Cash on Delivery</option>
                </select>

                <!-- Confirm Order Button -->
                <button type="submit" class="confirm-btn">Confirm Order</button>
            </form>
        </div>

    <% } else { %>
        <p>No items in the cart to proceed to checkout.</p>
    <% } %>
</div>

</body>
</html>
