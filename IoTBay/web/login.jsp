<%-- 
    Document   : login
    Created on : Mar 23, 2021, 1:36:40 PM
    Author     : Ruihui Lai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/login.css">
        <title>Login Page</title>
    </head>
    <body>
        <span id="links"> <a href="register.jsp"> Register</a> | <a href="index.jsp">Home </a></span>
                <center>
                <section>
                <div class="login_form">
                    <form action="welcome.jsp" method="post">
                        <h1>Login</h1>
                        <input type="text" name="email" placeholder="Email" required>
                        <input type="password" name="password" placeholder="Password" required>
                        <p><a class="forgot_password" href="retrieve_password.jsp">Forgot the password?</a></p>
                        <input type="submit" name="login" value="Login">                       
                        <p class="No_Account">Don't have an account？<a class="Resigter" href="register.jsp">Register</a></p>                     
                    </form>
                </div>
                <section>
    </body>
</html>
