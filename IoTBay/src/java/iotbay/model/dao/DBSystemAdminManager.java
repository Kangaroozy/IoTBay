package iotbay.model.dao;

import customer.SystemAdmin;
import java.sql.*;
import java.util.ArrayList;

public class DBSystemAdminManager {
    private Statement st;

    public DBSystemAdminManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
//Find user by email and password in the database   
    public SystemAdmin findSystemAdmin(String email, String password) throws SQLException {
        //setup the select sql query string       
        //execute this query using the statement field       
        //add the results to a ResultSet       
        //search the ResultSet for a user using the parameters               
        String fetch = "SELECT * FROM IOTUSER.SYSTEM_ADMIN WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String systemAdminEmail = rs.getString(4);
            String systemAdminPassword = rs.getString(5);
            if (systemAdminEmail.equals(email) && systemAdminPassword.equals(password)) {
                int systemAdminID = rs.getInt(1);
                String systemAdminFirstName = rs.getString(2);
                String systemAdminLastName = rs.getString(3);
                String systemAdminGender = rs.getString(6);
                String systemAdminAddress = rs.getString(7);
                String systemAdminPhone = rs.getString(8);
                String systemAdminStartDate = rs.getString(9);
                String systemAdminEndDate = rs.getString(10);
                String systemAdminPosition = rs.getString(11);
                return new SystemAdmin(systemAdminID, systemAdminFirstName, systemAdminLastName, systemAdminEmail, systemAdminPassword, systemAdminGender, systemAdminAddress, systemAdminPhone, systemAdminStartDate, systemAdminEndDate, systemAdminPosition);
            }
        }
        return null;
    }
//Add a user-data into the database   
    public void addSystemAdmin(String firstName, String lastName, String eMail, String password, String gender, String address, String phoneNumber, String startDate, String endDate, String position) throws SQLException {                   //code for add-operation       
        st.executeUpdate("INSERT INTO IOTUSER.SYSTEM_ADMIN (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, GENDER, ADDRESS, PHONENUMBER, STARTDATE, ENDDATE, POSITION) " + "VALUES('" + firstName + "','" + lastName + "','" + eMail + "','" + password + "','" + gender + "','" + address + "','" + phoneNumber + "','" + startDate + "','" + endDate + "','" + position + "')");
    }

//update a user details in the database   
    public void updateSystemAdmin(String userID, String firstName, String lastName, String eMail, String password, String gender, String address,  String phoneNumber, String startDate, String endDate, String position) throws SQLException {
        //code for update-operation   
        st.executeUpdate("UPDATE IOTUSER.SYSTEM_ADMIN SET FIRSTNAME='" + firstName + "', LASTNAME='" + lastName + "',EMAIL='" + eMail + "',PASSWORD='" + password + "',GENDER='" + gender + "',ADDRESS='" + address + "', PHONENUMBER='" + phoneNumber + "',STARTDATE='" + startDate + "', ENDDATE='"+ endDate +
                "' WHERE USERID=" + userID + "");
    }

//delete a user from the database   
    public void deleteStaff(String userID) throws SQLException {
        //code for delete-operation   
        st.executeUpdate("DELETE FROM IOTUSER.SYSTEM_ADMIN WHERE USERID=" + userID + "");
    }
    
    public ArrayList<SystemAdmin> fetchStaffs() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.SYSTEM_ADMIN");
        ArrayList<SystemAdmin> systemAdmins = new ArrayList();

        while (rs.next()) {
            int staffID = rs.getInt(1);
            String staffFirstName = rs.getString(2);
            String staffLastName = rs.getString(3);
            String staffEmail = rs.getString(4);
            String staffPassword = rs.getString(5);
            String staffGender = rs.getString(6);
            String staffAddress = rs.getString(7);
            String staffPhone = rs.getString(8);
            String staffStartDate = rs.getString(9);
            String staffEndDate = rs.getString(10);
            String staffPosition = rs.getString(11);
            systemAdmins.add(new SystemAdmin(staffID, staffFirstName, staffLastName, staffEmail, staffPassword, staffGender, staffAddress, staffPhone, staffStartDate, staffEndDate, staffPosition));
        }
        return systemAdmins;
    }
    
    public boolean checkSystemAdmin(String userID) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.SYSTEM_ADMIN WHERE USERID=" + userID + "");
        if (rs.next()) {
            return true;
        }
        return false;
    }
}