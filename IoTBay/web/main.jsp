<%-- 
    Document   : main
    Created on : Mar 20, 2021, 5:12:58 PM
    Author     : Ruihui Lai
--%>

<%@page import="customer.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/Main.css">
        <link rel="stylesheet" href="css/form.css">
        <title>Main Page</title>
    </head>
    <body>
        <span id="links"> <a href="logout.jsp"> Logout</a></span>
        <center>
        <h1>Main page of the website</h1>
        <%
            Customer customer = (Customer)session.getAttribute("customer");
        %>
        <center>
            <table>
        <tr><th>firstname</th><td>${customer.firstname}</td></tr>
        <tr><th>lastname</th><td>${customer.lastname}</td></tr>
        <tr><th>email</th><td>${customer.email}</td></tr>
        <tr><th>password</th><td>${customer.password}</td></tr>
        <tr><th>gender</th><td>${customer.gender}</td></tr>
        <tr><th>address</th><td>${customer.address}</td></tr>
        <tr><th>phone</th><td>${customer.phoneNumber}</td></tr>
        </table>
    </body>
</html>
