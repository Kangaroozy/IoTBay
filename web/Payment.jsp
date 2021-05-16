<%-- 
    Document   : Payment
    Created on : 2021-5-16, 0:39:25
    Author     : ASUS
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="iotbay.model.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotbay.model.dao.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/layout.css">
        <title>Payment Page</title>
    </head>
    
        <span id="links"><a href="MainPageServlet"> Main </a> | <a href="logout.jsp"> Logout</a></span>
        <div class="buttons">
            <input type="button" value="Create a payment" onclick="location.href = 'Create_Payment.jsp'">
            <input type="button" value="Find a payment" onclick="location.href = 'Find_Payment.jsp'">
        </div>
        <% 
            DBPaymentManager manager = (DBPaymentManager)session.getAttribute("paManager");
            ArrayList<Payment> payments = manager.fetchPayment();  
            //ArrayList<Payment> payments = (ArrayList<Payment>)request.getAttribute("list");
        %>
        <h1>Payment List</h1>
        <form action="PaymentListServlet" method="post" autocomplete="off">
        <table border="1" cellpadding="5" align="center">
            <caption><h2>List of Payments</h2></caption>
            <tr>
                <th>Payment ID</th>
                <th>Date</th>
                <th>PaymentMethod</th>
                <th>PaymentAmount</th>
                <th>OrderID</th>
                <th>CVV</th>
                <th>Creditnum</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            
            <%
                for(Payment payment:payments){
            %>        
            <tr>
                <td><%=payment.getPaymentID()%></td>
                <td><%=payment.getDate()%></td>
                <td><%=payment.getPaymentMethod()%></td>
                <td><%=payment.getPaymentAmount()%></td>
                <td><%=payment.getOrderID()%></td>
                <td><%=payment.getCVV()%></td>
                <td><%=payment.getCreditNum()%></td>
                <td><a href="PaymentEditServlet?ID=<%=payment.getPaymentID()%>">Edit</a></td>
                <td><a href="Delete_Payment.jsp?id=<%=payment.getPaymentID()%>" onclick="">Delete</a>
            </tr>
            <%}%>
        </table>
           
        
    
</html>
