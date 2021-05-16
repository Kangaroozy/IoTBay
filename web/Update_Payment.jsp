<%-- 
    Document   : Update_Payment
    Created on : 2021-5-8, 14:37:50
    Author     : ASUS
--%>

<%@page import="iotbay.model.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
        <%
            Payment payment = (Payment) request.getAttribute("payment");
        %>
    </head>
    <body>
        <span><a href="Payment.jsp">Back</a> | <a href="logout.jsp">Logout</a></span>
        <form id="form" action="PaymentUpdateServlet" method="post">
            <table>
                <tr><td>Payment ID:</td><td>${payment.paymentID}</td></tr>
                <tr><td>Date:</td><td>${payment.date}</td></tr>
                <tr><td>Payment Method:</td><td><input type="text" name="PaymentMethod" value="${payment.paymentMethod}"></td></tr>
                <tr><td>Payment Amount:</td><td><input type="text" name="paymentAmount" value="${payment.paymentAmount}"></td></tr>
                <tr><td>Order ID:</td><td><input type="text" name="OrderID" value="${payment.orderID}"></td></tr>
                <tr><td>CVV:</td><td><input type="text" name="CVV" value="<%=payment.getCVV()%>"></td></tr>
                <tr><td>Creditnum:</td><td><input type="text" name="CreditNum" value="<%=payment.getCreditNum()%>"></td></tr>
            </table>
            <div>
                <input type="hidden" name="paymentID" value="<%=payment.getPaymentID()%>">
                <a href="main.jsp">Cancel</a> <input class="button" type="submit" value="Update">
            </div>
    </body>
</html>
