<%@page import="com.tap.daoimpls.RestaurantDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Restaurant" %>
<%@ page import="com.tap.model.User" %>
<%@ page import="com.tap.daoimpls.RestaurantDAOImpl"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>APPYPIE Food Delivery</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <!-- Navbar -->
    <header>
        <div class="navbar">
            <div class="logo">
                <a href="index.jsp">APPYPIE</a>
            </div>
            <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    
                    <% User loggedInUser = (User)session.getAttribute("loggedInUser"); %>
                    
                    <% if(loggedInUser != null)
                    {%>
                    	<li><a href="cart">View Cart</a></li>
                    	<li><a href="orderhistory">Order History</a></li>
                    	<li><a href="logout">Logout</a></li>
                    	
                    	<!-- Welcome Pop-up -->
                        <div id="welcomePopup" class="popup">
                            Welcome, <%= loggedInUser.getUsername() %>!
                        </div>
                        
                        <!-- Optional: Overlay for the popup -->
                        <div id="popupOverlay" class="popup-overlay"></div>

                        <script>
                            // Show pop-up and hide after 10 seconds
                            window.onload = function() {
                                var popup = document.getElementById('welcomePopup');
                                // var overlay = document.getElementById('popupOverlay');

                                // Show the pop-up
                                popup.classList.add('show');
                                // overlay.classList.add('show'); // If using overlay

                                // Hide the pop-up after 10 seconds
                                setTimeout(function() {
                                    popup.classList.remove('show');
                                    // overlay.classList.remove('show'); // If using overlay
                                }, 10000); // 10,000 milliseconds = 10 seconds
                            }
                        </script>
                   	<%}
                   	else
                   	{ %>
	                   	<li><a href="register.jsp">Sign Up</a></li>
	                    <li><a href="login.jsp">Sign In</a></li>
                   	<% }%>

                </ul>
            </nav>
        </div>
    </header>

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
