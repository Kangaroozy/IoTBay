<%-- 
    Document   : login
    Created on : Mar 20, 2021, 1:36:40 PM
    Author     : Reyvaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/login.css">
        <title>Login Page</title>
    </head>
    <body>
        <div>
        <span id="links"> <a href="index.jsp">Home</a></span>
        </div>
        <div class="login_form">
            <form action="welcome.jsp" method="post">
                <h1>Login</h1>
                <p class ="head ">E-mail</p>
                <input type="text" name="email" placeholder="E-mail" required>
                <p class ="head">Password</p>
                <input type="password" name="password" placeholder="Password" required>
                <p><a class="forgot_password" href="retrieve_password.jsp">Forgot your password?</a></p>
                <input type="submit" name="login" value="Login">                       
                <p>Don't have an account？<a class="Resigter" href="register.jsp">Register</a></p>                     
            </form>
        </div>
    </body>
</html>
