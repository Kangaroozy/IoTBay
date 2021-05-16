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
            String cvvErr = (String) session.getAttribute("postcodeErr");
            String buildPath = request.getServletContext().getRealPath("");
            String dateErr = (String) session.getAttribute("dateErr");
            String iotBayPath = buildPath.substring(0, buildPath.length() - 9);
        %>
        <form action="CreatePaymentServlet" method="post"
              enctype="multipart/form-data">
            <table>
                <td><table>
                    <tr><td>Payment Method</td>
                        <td><input type="text" name="PaymentMethod" placeholder="" required></td></tr>
                    <tr><td>Card Number</td>
                        <td><input type="text" name="CardNumber" placeholder="" required></td></tr>
                    <tr><td>CVV</td>
                        <td><input type="number" name="CVV" placeholder="" required></td></tr>
                    <tr><td>Date</td>
                        <td><input type="text" placeholder="<%=(dateErr !=null ? dateErr:"Enter the date")%>" name="date"/></td><td>
                    <tr><td><a href="main.jsp"></a><input type="submit" name="submit" value="Create"></td></tr>
                    
                </table></td>
            </table>
        </form>
    </body>
</html>
