<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tap.model.OrderHistory" %>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order History</title>
<link rel="stylesheet" type="text/css" href="orderhistory.css">
</head>
<body>

<div class="container">
    <h1>Order History</h1>
    
    <% 
        List<OrderHistory> orderhistory = (List<OrderHistory>) session.getAttribute("orderhistoryList");
        if (orderhistory != null && !orderhistory.isEmpty()) { %>
        
        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Order Date</th>
                    <th>Total Amount</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <% for(OrderHistory oh : orderhistory) { %>
                <tr>
                    <td><%= oh.getOrderId() %></td>
                    <td><%= oh.getOrderDate() %></td>
                    <td>₹<%= oh.getTotalAmount() %></td>
                    <td><%= oh.getStatus() %></td>
                    <td>
                        <form action="orderdetails">
                            <input type="hidden" name="orderId" value="<%= oh.getOrderId() %>">
                            <button type="submit" class="view-btn">View</button>
                        </form>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>

    <% } else { %>
        <h2>You have not made any orders till now!</h2>
    <% } %>

</div>

</body>
</html>
