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
                <a href="index.jsp">APPYPIE</a>
            </div>
            <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    
                    <% 
                    // Retrieving the logged-in user from session
                    User loggedInUser = (User) session.getAttribute("loggedInUser"); 
                    %>
                    
                    <!-- If the user is logged in -->
                    <% if(loggedInUser != null) { %>
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

 