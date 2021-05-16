<%-- 
    Document   : pwelcome
    Created on : Mar 19, 2021, 12:40:08 PM
    Author     : Ruihui Lai
--%>

<%@page import="customer.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/welcome.css">
        <title>Welcome Page</title>
    </head>
    <body>
        <div class="welcome">
            <h1> Welcome!</h1>
            <p>welcome to the IoTBay Website! you will be redirected in 5 seconds</p><br>
            <h6>if you are not automatically redirected please <a href="main.jsp"> click here</a></h6>
        </div>
        <%
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String address = request.getParameter("address");
            String phoneNumber = request.getParameter("phonenumber");
            Customer customer = new Customer(1, firstname,lastname, email, password, gender, address, phoneNumber);
            session.setAttribute("customer", customer);
        %>
        
        <% response.setHeader("Refresh", "5;url=main.jsp"); %>
    </body>
</html>
