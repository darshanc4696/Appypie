<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
<link rel="stylesheet" type="text/css" href="login.css">
<script>
    // JavaScript function to validate the form fields
    function validateForm() {
        var email = document.forms["loginForm"]["email"].value;
        var password = document.forms["loginForm"]["password"].value;

        if (email === "") {
            alert("Please enter your email");
            return false; // Prevent form submission
        }
        if (password === "") {
            alert("Please enter your password");
            return false; // Prevent form submission
        }
        return true; // Allow form submission
    }
</script>
</head>
<body>

<div class="container">
    <h1>Sign In</h1>
    <!-- Adding a name attribute to the form for validation -->
    <form name="loginForm" action="login" onsubmit="return validateForm()">
        <table>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" placeholder="Enter your email"></td>
            </tr>

            <tr>
                <td>Password</td>
                <td><input type="password" name="password" placeholder="Enter your password"></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" name="Login" value="Login"></td>
            </tr>  

            <tr>
                <td colspan="2"><a href="register.jsp">New User? Click Here</a></td>
            </tr>         
        </table>
    </form>
</div>

</body>
</html>
