<%@page import="com.tap.daoimpls.RestaurantDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Restaurant" %>
<%@ page import="com.tap.model.User" %>
<%@ page import="com.tap.daoimpls.RestaurantDAOImpl"%>
<%@ include file="navbar.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>APPYPIE Food Delivery</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

    <!-- Hero Section -->
    <section class="hero">
        <div class="hero-content">
            <h1>Order Delicious Food Online with APPYPIE</h1>
            <p>Quick and easy food delivery from your favorite restaurants!</p>
        </div>
    </section>

    <!-- Restaurants Section -->
<section class="restaurants">
    <h2>Popular Restaurants</h2>
    <div class="restaurant-list">
        <% RestaurantDAOImpl rdaoi = new RestaurantDAOImpl();
           List<Restaurant> restaurantList = rdaoi.fetchAllRestaurant();
           if (restaurantList != null) {
               for (Restaurant restaurant : restaurantList) { %>
                   <div class="restaurant-card">
                       <img src="<%= restaurant.getImgPath() %>" alt="<%= restaurant.getRestaurantName() %>">
                       <div class="restaurant-info">
                           <h3><%= restaurant.getRestaurantName() %></h3>
                           <p>
                               <span class="rating">★ <%= restaurant.getRatings() %></span> 
                               • <%= restaurant.getDeliveryTime() %> mins
                           </p>
                           <p><%= restaurant.getCuisineType() %></p>
                           <p><%= restaurant.getAddress() %></p>
                       </div>
                       <a href="menu?restaurantId=<%= restaurant.getRestaurantId() %>" class="view-menu">
                           View Menu
                       </a>
                   </div>
        <%     }
           } else { %>
           <p>No restaurants available at the moment.</p>
        <% } %>
    </div>
</section>


    <!-- Footer -->
    <footer>
        <p>&copy; 2024 APPYPIE. All Rights Reserved.</p>
    </footer>
</body>
</html>
