<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Confirmed</title>

    <!-- Embedded CSS -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .confirmation-container {
            text-align: center;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        /* Checkmark Container */
        .checkmark-container {
            width: 100px;
            height: 100px;
            position: relative;
            margin: 0 auto 20px auto;
            border-radius: 50%;
            background-color: #00b894;
            animation: pop-in 0.3s ease-in-out forwards;
        }

        /* Circle Outline */
        .checkmark-circle {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            border: 5px solid #00b894;
            background-color: white;
            position: absolute;
            top: 0;
            left: 0;
        }

		        /* Checkmark Stem */
		.checkmark-stem {
		    width: 5px;
		    height: 20px; /* Decreased to fit better */
		    background-color: #00b894;
		    position: absolute;
		    top: 45px; /* Adjusted to move closer to center */
		    left: 48px; /* Adjusted for proper alignment */
		    transform: rotate(45deg);
		    transform-origin: bottom;
		    animation: draw-stem 0.4s 0.3s ease forwards;
		}
		
		/* Checkmark Kick */
		.checkmark-kick {
		    width: 5px;
		    height: 10px; /* Adjusted to fit */
		    background-color: #00b894;
		    position: absolute;
		    top: 60px; /* Adjusted to position it better */
		    left: 50px; /* Adjusted for proper alignment */
		    transform: rotate(-45deg);
		    transform-origin: bottom left;
		    animation: draw-kick 0.3s 0.7s ease forwards;
		}


        /* Heading */
        h1 {
            font-size: 28px;
            color: #333;
            margin-bottom: 10px;
        }

        /* Paragraph */
        p {
            font-size: 16px;
            color: #666;
            margin-bottom: 30px;
        }

        /* Back to Home Button */
        .back-home-btn {
            padding: 10px 20px;
            background-color: #00b894;
            color: white;
            text-decoration: none;
            font-size: 16px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .back-home-btn:hover {
            background-color: #019d7f;
        }

        /* Keyframe Animations */
        @keyframes pop-in {
            0% { transform: scale(0); }
            100% { transform: scale(1); }
        }

        @keyframes draw-stem {
            0% { height: 0; }
            100% { height: 30px; }
        }

        @keyframes draw-kick {
            0% { height: 0; }
            100% { height: 15px; }
        }
    </style>
</head>
<body>

    <!-- Confirmation Container -->
    <div class="confirmation-container">
        
        <!-- Checkmark Animation -->
        <div class="checkmark-container">
            <div class="checkmark-circle"></div>
            <div class="checkmark-stem"></div>
            <div class="checkmark-kick"></div>
        </div>
        
        <!-- Order Confirmation Message -->
        <h1>Order Confirmed!</h1>
        <p>Your order was successfully placed.</p>

        <!-- Button to Return to Home Page -->
        <a href="index.jsp" class="back-home-btn">Back to Home</a>
    </div>

</body>
</html>
