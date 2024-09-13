<%@page import="com.tap.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>APPYPIE Food Delivery</title>
    <link rel="stylesheet" href="styles.css"> <!-- Link to your common CSS file -->
</head>
<body>
    <!-- Navbar -->
    <header>
        <div class="navbar">
            <div class="logo">
                <a href="index.jsp">
                    <img src="images/Appypielogo.jpg" alt="Appypie Logo" class="logo-img"> <!-- Appypie logo -->
                    APPYPIE
                </a>
            </div>
            <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>

                    <% 
                    // Retrieving the logged-in user from session
                    User loggedInUser = (User) session.getAttribute("loggedInUser");
                    Boolean popupShown = (Boolean) session.getAttribute("popupShown"); // Get popupShown attribute
                    %>

                    <!-- If the user is logged in -->
                    <% if(loggedInUser != null) { %>
                        <li><a href="cart.jsp">View Cart</a></li>
                        <li><a href="orderhistory">Order History</a></li>
                        <li><a href="logout">Logout</a></li>

                        <!-- Show the welcome pop-up only if it hasn't been shown yet -->
                        <% if (popupShown == null || !popupShown) { %>
                            <div id="welcomePopup" class="popup">
                                Welcome, <%= loggedInUser.getUsername() %>!
                            </div>

                            <!-- Optional: Overlay for the popup -->
                            <div id="popupOverlay" class="popup-overlay"></div>

                            <script>
                                // Show pop-up and hide after 10 seconds
                                window.onload = function() {
                                    var popup = document.getElementById('welcomePopup');

                                    // Show the pop-up
                                    popup.classList.add('show');

                                    // Hide the pop-up after 10 seconds
                                    setTimeout(function() {
                                        popup.classList.remove('show');
                                    }, 10000); // 10,000 milliseconds = 10 seconds
                                }
                            </script>

                            <!-- Update session attribute to prevent pop-up from showing again -->
                            <%
                                session.setAttribute("popupShown", true);
                            %>
                        <% } %>
                    <% } else { %>
                        <!-- If the user is not logged in -->
                        <li><a href="register.jsp">Sign Up</a></li>
                        <li><a href="login.jsp">Sign In</a></li>
                    <% } %>
                </ul>
            </nav>
        </div>
    </header>
</body>
</html>
