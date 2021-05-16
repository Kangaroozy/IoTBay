<%-- 
    Document   : forgotPassword
    Created on : Mar 29, 2021, 10:57:39 PM
    Author     : Ruihui Lai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/retrieve_password.css">
        <title>Retrieve Page</title>
    </head>
    <body>
        <section>
            <div class="retrieve_form">
                  <form action="?.jsp" method="post">
                      <h1>Retrieve Password</h1>
                      <input type="text" name="Email" placeholder="Email" required>
                      <p><a class="forgot_password" href="login.jsp">cancel?</a></p>
                      <input type="submit" name="Reset" value="Reset password">                                          
                  </form>
              </div>
        <section>
    </body>
</html>
