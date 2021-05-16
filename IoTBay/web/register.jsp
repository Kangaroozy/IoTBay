<%-- 
    Document   : register
    Created on : Mar 23, 2021, 11:26:36 AM
    Author     : Ruihui Lai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/register.css">
        <title>Register Page</title>
    </head>
    <body>  
            <span id="links"> <a href="index.jsp">Home </a></span>
            <center>
                <section>
                <div class="login_form">
                    <form action="welcome.jsp" method="post">
                        <h1>Register</h1>
                        <input type="text" name="email" placeholder="email" required>
                        <input type="text" name="firstname" placeholder="firstname" required>
                        <input type="text" name="lastname" placeholder="lastame" required>
                        <input type="password" name="password" placeholder="password" required>
                        <input name="gender" name="gender" placeholder="gender" required>
                        <input type="text" name="address" placeholder="address" required>
                        <input type="tel" name="phonenumber" placeholder="phone_number" required>
                        <input type="submit" name="Register" value="Register">   
                        Already have an account? <a href="login.jsp"> Login</a>
                    </form>
    </body>
</html>
