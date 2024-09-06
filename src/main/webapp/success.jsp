<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #fff; /* White background */
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    
    .container {
        text-align: center;
        background-color: #000; /* Black background */
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        color: #fff; /* White text */
    }
    
    h1 {
        color: #fc8019; /* Swiggy's orange */
        margin-bottom: 20px;
    }
    
    a {
        display: inline-block;
        background-color: #fc8019; /* Swiggy's orange */
        color: #fff;
        padding: 10px 20px;
        text-decoration: none;
        border-radius: 5px;
        font-weight: bold;
        transition: background-color 0.3s ease;
    }
    
    a:hover {
        background-color: #d5690a; /* Darker shade of orange for hover */
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Successfully registered!</h1>
        <a href="index.jsp">Back to Home Page</a>
    </div>
</body>
</html>
