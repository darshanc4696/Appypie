<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                    <li><a href="#">About</a></li>
                    <li><a href="#">Contact</a></li>
                    <li><a href="register.jsp">Sign Up</a></li>
                    <li><a href="login.jsp">Sign In</a></li>
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
            <div class="restaurant-card">
                <img src="restaurant1.jpg" alt="Restaurant 1">
                <h3>Restaurant 1</h3>
                <p>Famous for Italian Cuisine</p>
            </div>
            <div class="restaurant-card">
                <img src="restaurant2.jpg" alt="Restaurant 2">
                <h3>Restaurant 2</h3>
                <p>Best South Indian Dishes</p>
            </div>
            <div class="restaurant-card">
                <img src="restaurant3.jpg" alt="Restaurant 3">
                <h3>Restaurant 3</h3>
                <p>Authentic Chinese Food</p>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 APPYPIE. All Rights Reserved.</p>
    </footer>
</body>
</html>
