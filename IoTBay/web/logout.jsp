<%-- 
    Document   : logout
    Created on : Mar 19, 2021, 12:48:15 PM
    Author     : Ruihui Lai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/logout.css">
        <title>logout Page</title>
    </head>
    <center>
    <body>
        <h1>You have successfully logged out!</h1>
        <a href="index.jsp"> go back to index
        <% session.invalidate(); %>
    </body>
</html>
