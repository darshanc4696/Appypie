<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="register.css"> <!-- External CSS -->
<script>
    function validateForm() {
        var name = document.forms["registerForm"]["name"].value;
        var email = document.forms["registerForm"]["email"].value;
        var phoneNumber = document.forms["registerForm"]["phoneNumber"].value;
        var address = document.forms["registerForm"]["address"].value;
        var password = document.forms["registerForm"]["password"].value;
        var cpassword = document.forms["registerForm"]["cpassword"].value;
        
        if (name == "" || email == "" || phoneNumber == "" || address == "" || password == "" || cpassword == "") {
            alert("Please fill in all fields.");
            return false; // Prevent form submission
        }

        if (password !== cpassword) {
            alert("Passwords do not match.");
            return false; // Prevent form submission
        }
        
        return true; // Allow form submission
    }
</script>
</head>
<body>

<div id="registerModal" class="modal">
    <div class="modal-content">

        <h1>Sign Up</h1>
        <form  name ="registerForm" action="register" method="post" onsubmit="return validateForm()">
            <table>
                <tr>
                    <td><label>Name</label> </td>
                    <td><input type="text" name="name" placeholder="Enter your name"></td>
                </tr>
                <tr>
                    <td><label>Email</label> </td>
                    <td><input type="email" name="email" placeholder="Enter your email"></td>
                </tr>
                <tr>
                    <td><label>Phone Number</label> </td>
                    <td><input type="text" name="phoneNumber" placeholder="Enter your phone number"></td>
                </tr>
                <tr>
                    <td><label>Address</label> </td>
                    <td><input type="text" name="address" placeholder="Enter your address"></td>
                </tr>
                <tr>
                    <td><label>Password</label> </td>
                    <td><input type="password" name="password" placeholder="Enter your password"></td>
                </tr>
                <tr>
                    <td><label>Confirm Password</label> </td>
                    <td><input type="password" name="cpassword" placeholder="Confirm your password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Register"></td>
                </tr>
            </table>
        </form>
    </div>
</div>

<script>
    // Get the modal
    var modal = document.getElementById('registerModal');
    
    // Get the button that opens the modal
    document.querySelector('body').onload = function() {
        modal.style.display = "block";
    };
    
    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName('close')[0];
    
    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    };
</script>

</body>
</html>
