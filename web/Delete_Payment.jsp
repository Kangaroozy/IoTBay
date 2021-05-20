<%-- 
    Document   : Delete_Payment
    Created on : 2021-5-8, 14:38:59
    Author     : ASUS
--%>
<%@page import="iotbay.model.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Payment</title>
    </head>
    <body>
        <h1>Delete Payment</h1>
        <%
            Payment payment = (Payment) request.getAttribute("payment");
        %>
        <form action="DeletePaymentServlet"  method="post"
              enctype="multipart/form-data">
                <table id="table">
                    <tr><td>PaymentID:</td><td><input type="text" name="paymentID" required="true"></td></tr>
                    
                </table>
                <div>
                    <a href="Payment.jsp">Cancle</a>  
                    <input class="button" type="submit" value="Delete">
                </div>
            </form>
    </body>
</html>
