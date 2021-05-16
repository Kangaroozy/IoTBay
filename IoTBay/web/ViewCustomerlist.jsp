<%-- 
    Document   : ViewCustomerlist
    Created on : 2021年5月10日, 下午2:54:33
    Author     : 13725
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="customer.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="iotbay.model.dao.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/Main.css">
        <link rel="stylesheet" href="css/form.css">
        <title>View Customer list</title>
    </head>
    <body>
        <span id="links"> <a href="customer_upload.jsp"> upload</a></span> | <a href="logout.jsp"> Logout</a> <a href="ViewCustomerlist.jsp"> Viewcustomerlist </a></span>
        <h1> Main page</h1>
        <%
            DBConnector connector = new DBConnector();
            Connection conn = connector.connection();
            CustomerManager db = new CustomerManager(conn);
            ArrayList<Customer> customers = db.fetchCustomers();
            %>
            
                    <div class="mainTable">
            <form action="CustomerViewServlet" method="post" autocomplete="off">
                <input type="number" name="filter" placeholder="Customer ID">
                <input type="submit" id="submit" name="submit" value="search">
                </from>
                
                <table>
                    <%for (Customer customer : customers){%>
                <tr>
                    <td><%=customer=getCustomerID()%></td>
                        firstname: <%=customer=getfirstname%><br>
                        lastname: <%=customer=getlastname%><br>
                        email: <%=customer=getemail%><br>
                        password: <%=customer=getpassword%><br>
                        gender: <%=customer=getgender%><br>
                        address: <%=customer=getaddress%><br>
                        phonenumber: <%=customer=getphonenumber%><br>
                        </a>
                    </td>    
                <%}%>
                </table>
    </body>
</html>
