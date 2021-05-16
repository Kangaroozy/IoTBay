<%-- 
    Document   : edit
    Created on : 2021年5月13日, 下午4:21:38
    Author     : 13725
--%>

<%@page import="customer.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/Main.css">
<script type="text/javascript" src="js/script.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
    </head>
    <body onload="startTime ()">
        <%
            Customer customer = (Customer) session.getAttribute("customer");
            String updated = (String)session.getAttribute("update");
            String deleted = (String)session.getAttribute("deleted");
        %>
        <div class="panel_div">
            <a class=""button" href="MainServlet?email='<%= customer.geteMail()%>'&password='<%=customer.getPassword()%>'"> Main </a>
            <a class="button" href="logout.jsp"> Logout </a>
        </div>
            
        <hi>Edit Customer information: <span class="message"> <%=(updated != null ? updated : "")%></span></h1>
        <form method="post" action="UpdateCustomerServlet">
            <table id="form_table">
                <tr><td>FirstName:</td><td><input type"text" name="Firstname" value="${customer.Firstname}"></td></tr>
                <tr><td>LastName:</td><td><input type"text" name="Lastname" value="${customer.Lastname}"></td></tr>
                <tr><td>email:</td><td><input type"text" name="email" value="${customer.email}"></td></tr>
                <tr><td>password:</td><td><input type"password" name="password" value="${customer.password}"></td></tr>
                <tr><td>gender:</td><td><input type"text" name="gender" value="${customer.gender}"></td></tr>
                <tr><td>address:</td><td><input type"text" name="address" value="${customer.address}"></td></tr>
                <tr><td>phonenumber:</td><td><input type"text" name="phonenumber" value="${customer.phonenumber}"></td></tr>
                    <td>
                        <input class="button" type="submit" value="Update">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
