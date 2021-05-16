<%-- 
    Document   : main
    Created on : Mar 20, 2021, 5:12:58 PM
    Author     : Reyvaldo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="iotbay.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotbay.model.dao.*"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/layout.css">
        <title>Main Page</title>
    </head>
    <body>
        <span id="links"><a href="ProductListServlet"> Staff View</a> | <a href="Payment.jsp"> Payment</a> |<a href="profile.jsp"> Profile</a> | <a href="ViewAllOrderServlet"> View All Orders</a> | <a href="LogoutServlet"> Logout</a></span>
        <h1>Main page</h1>
        <%
            ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("list");
            ArrayList<String> listCategory = (ArrayList<String>) request.getAttribute("cate");
            String filter = (String) request.getAttribute("filter");
            String cat = (String) request.getAttribute("cat");
            String staffOnly = (String) request.getAttribute("staffOnly");
            int length = products.size();
        %>

        <center><div class="mainTable">
                <h1><%=(staffOnly != null ? staffOnly : "")%></h1>
            item count: <%=length%>
            <form action="MainPageServlet" method="post" autocomplete="off">
                <input type="text" name="filter" value="<%=(filter != null ? filter : "")%>" placeholder="item name">
                <input list="categories" name="category" value="<%=(cat != null ? cat : "")%>" placeholder="category">
                <datalist id = "categories">
                    <option value="ALL">
                        <%for (String category : listCategory) {%>
                    <option value="<%=category%>">
                        <%}%>
                </datalist>
                <input type="submit" id="submit" name="submit" value="search">
            </form><br>
            <table>
                <%
                    int i = 0;
                    for (Product product : products) {

                        if (i % 5 == 0) {
                %>
                <tr></tr>
                <%
                    }
                    i++;
                %>
                <td>
                    <a href="ProductViewServlet?ID=<%=product.getProductID()%>">
                        <center><img src="productPictures/<%=product.getProductID()%>.jpg" onerror="this.onerror=null;this.src='productPictures/noImage.jpg'" height="128" width="128"><br>
                            <%=product.getName()%><br>
                            $ <%=product.getPrice()%><br>
                            Stock <%=product.getStock()%><br>
                        </center>
                    </a>
                </td>
                <%}%>
            </table>
        </div>
    </body>
</html>
