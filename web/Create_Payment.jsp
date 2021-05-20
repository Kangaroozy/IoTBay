<%-- 
    Document   : Create_Payment
    Created on : 2021-5-8, 14:37:38
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Payment</title>
    </head>
    <body>
        <h1>Create Payment</h1>
        <%
            
            String dateErr = (String) session.getAttribute("dateErr");
        %>
        <form action="CreatePaymentServlet" method="post"
              enctype="multipart/form-data">
            <table>
                <td><table>
                    <tr><td>Payment Method</td>
                        <td><input type="text" name="PaymentMethod" placeholder="" required="true"></td></tr>
                    <tr><td>Payment Amount</td>
                        <td><input type="text" name="paymentAmount" placeholder="" required="true"></td></tr>
                     <tr><td>Order ID</td>
                        <td><input type="text" name="OrderID" placeholder="" required="true"></td></tr>   
                    <tr><td>CVV</td>
                        <td><input type="number" name="CVV" placeholder="" required="true"></td></tr>
                     <tr><td>Card Number</td>
                        <td><input type="text" name="CreditNum" placeholder="" required="true"></td></tr>                   
                    <tr><td>Date</td>
                        <td><input type="text" placeholder="<%=(dateErr !=null ? dateErr:"Enter the date")%>" name="Date" required="true"/></td></tr>
                            
                    <tr><td><input type="submit" class="Button" value="Create"></td></tr>
                    
                </table></td>
            </table>
        </form>
    </body>
</html>
