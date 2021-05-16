<%-- 
    Document   : index
    Created on : Mar 19, 2021, 11:24:20 AM
    Author     : Ruihui Lai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/index.css">
        <title>Home Page</title>
    </head>
    <body>
        <img src="css/IoTBay_Icon.png" alt="">
        <div class="buttons">
            <input type="button" value="Login" onclick="location.href='login.jsp'">
            <input type="button" value="Register" onclick="location.href='register.jsp'">
        </div>
        <jsp:include page="/ConnServlet" flush="true"/>
    </body>
</html>
