  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.model.dao;

import customer.Customer;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
 */
public class DBCustomerManager {

    private Statement st;

    public DBCustomerManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

//Find user by email and password in the database   
    public Customer findCustomer(String email, String password) throws SQLException {
        //setup the select sql query string       
        //execute this query using the statement field       
        //add the results to a ResultSet       
        //search the ResultSet for a user using the parameters               
        String fetch = "SELECT * FROM IOTUSER.CUSTOMER WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String customerEmail = rs.getString(4);
            String customerPassword = rs.getString(5);
            if (customerEmail.equals(email) && customerPassword.equals(password)) {
                int customerID = rs.getInt(1);
                String customerFirstName = rs.getString(2);
                String customerLastName = rs.getString(3);
                String customerGender = rs.getString(6);
                String customerAddress = rs.getString(7);
                String customerPhone = rs.getString(8);
                return new Customer(customerID, customerFirstName, customerLastName, customerEmail, customerPassword, customerGender, customerAddress, customerPhone);
            }
        }
        return null;
    }

//Add a user-data into the database   
    public void addCustomer(String firstName, String lastName, String eMail, String password, String gender, String address, String phoneNumber) throws SQLException {                   //code for add-operation       
        st.executeUpdate("INSERT INTO IOTUSER.CUSTOMER (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, GENDER, ADDRESS, PHONENUMBER) " + "VALUES('" + firstName + "','" + lastName + "','" + eMail + "','" + password + "','" + gender + "','" + address + "','" + phoneNumber + "')");
    }

//update a user details in the database   
    public void updateCustomer(String userID, String firstName, String lastName, String eMail, String password, String gender, String address, String phoneNumber) throws SQLException {
        //code for update-operation   
        st.executeUpdate("UPDATE IOTUSER.CUSTOMER SET FIRSTNAME='" + firstName + "', LASTNAME='" + lastName + "',EMAIL='" + eMail + "',PASSWORD='" + password + "',GENDER='" + gender + "',ADDRESS='" + address + "', PHONENUMBER='" + phoneNumber + "' WHERE USERID=" + userID + "");
    }

//delete a user from the database   
    public void deleteCustomer(String userID) throws SQLException {
        //code for delete-operation   
        st.executeUpdate("DELETE FROM IOTUSER.CUSTOMER WHERE USERID='" + userID + "'");
    }

    public ArrayList<Customer> fetchCustomers() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.CUSTOMER");
        ArrayList<Customer> customers = new ArrayList();

        while (rs.next()) {
            int customerID = rs.getInt(1);
            String customerFirstName = rs.getString(2);
            String customerLastName = rs.getString(3);
            String customerEmail = rs.getString(4);
            String customerPassword = rs.getString(5);
            String customerGender = rs.getString(6);
            String customerAddress = rs.getString(7);
            String customerPhone = rs.getString(8);
            boolean subscription = rs.getBoolean(9);
            customers.add(new Customer(customerID, customerFirstName, customerLastName, customerEmail, customerPassword, customerGender, customerAddress, customerPhone));
        }
        return customers;
    }

    public boolean checkCustomer(String userID) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.CUSTOMER WHERE USERID=" + userID + "");
        if (rs.next()) {
            return true;
        }
        return false;
    }
}