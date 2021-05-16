/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.model.dao;

import iotbay.model.Payment;
import java.sql.*;
import java.util.ArrayList;


public class DBPaymentManager {
    private Statement st;
    public DBPaymentManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    public Payment findPayment(int PayID) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.PAYMENT WHERE PAYMENTID=" + PayID + "";
        ResultSet rs = st.executeQuery(fetch);
        while(rs.next()){
            int paymentID = rs.getInt(1);
            if (paymentID == paymentID) {
                String date = rs.getString(2);
                String paymentMethod = rs.getString(3);
                int orderID = rs.getInt(4);
                double paymentAmount = rs.getDouble(5);
                int cvv = rs.getInt(6);
                String creditnum = rs.getString(7);
                return new Payment(paymentID, date, paymentMethod, orderID, paymentAmount, cvv, creditnum );
            }
        }return null;
    }
    public void addPayment(String date,int orderID, int paymentID, double paymentAmount, String paymentMethod, int cvv, String creditnum) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.PAYMENT DATE, ORDERID, PAYMENTID, PAYMENTAMOUNT, PAYMENTMETHOD, CVV,CREDITNUMBER " + "VALUES('" + date +"','" + orderID +"', '" + paymentID + "','" + paymentAmount + "','" + paymentMethod + "', '" + cvv + "','" + creditnum + "')");
    }

     public Payment readPayment(int PaymentID, String Date) throws SQLException {
        String fetch = "SELECT * FROM IOTUSER.PAYMENT WHERE PAYMENTID=" + PaymentID + " AND DATE='" + Date + "'";//read from where paymentID = and date = 
        ArrayList<Payment> payments = new ArrayList();
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int paymentID = rs.getInt(1);
                String date = rs.getString(2);
                String paymentMethod = rs.getString(3);
                int orderID = rs.getInt(4);
                double paymentAmount = rs.getDouble(5);
                int cvv = rs.getInt(6);
                String creditnum = rs.getString(7);
            payments.add(new Payment(paymentID, date, paymentMethod, orderID, paymentAmount, cvv, creditnum));
        }
        return null;
    }    
    
//update a user details in the database   
    public void updatePayment(int paymentID, String paymentMethod, int orderID, double paymentAmount, int cvv, String creditnum) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.PAYMENT SET PAYMENTMETHOD='" + paymentMethod + "', ORDERID=" + orderID + ",PAYMENTAMOUNT=" + paymentAmount + " WHERE PAYMENTID=" + paymentID + " AND CVV=" + cvv + " AND CREDITNUM='" + creditnum+"'");
    }

//delete a user from the database   
    public void deletePayment(int paymentID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.PAYMENT WHERE PAYMENTID=" + paymentID + "");
    }
    public ArrayList<Payment> fetchPayment() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.PAYMENT");
        ArrayList<Payment> payments = new ArrayList();

        while (rs.next()) {
            int paymentID = rs.getInt(1);
                String date = rs.getString(2);
                String paymentMethod = rs.getString(3);
                int orderID = rs.getInt(4);
                double paymentAmount = rs.getDouble(5);
                int cvv = rs.getInt(6);
                String creditnum = rs.getString(7);
            payments.add(new Payment(paymentID, date, paymentMethod, orderID, paymentAmount, cvv, creditnum));
        }
        return payments;
    }

    public boolean checkPayment(int paymentID) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.\"PAYMENT\" WHERE PAYMENTID=" + paymentID + "");
        if (rs.next()) {
            return true;
        }
        return false;
    }
    
    public ArrayList<Payment> searchPayment(String dates) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM IOTUSER.PAYMENT WHERE PaymentID LIKE '%"+dates+"%'");
        ArrayList<Payment> payments = new ArrayList();

        while (rs.next()) {
            int paymentID = rs.getInt(1);
            String date = rs.getString(2);
                String paymentMethod = rs.getString(3);
                int orderID = rs.getInt(4);
                double paymentAmount = rs.getDouble(5);
                int cvv = rs.getInt(6);
                String creditnum = rs.getString(7);
            payments.add(new Payment(paymentID, date, paymentMethod, orderID, paymentAmount, cvv, creditnum ));
        }
        return payments;
    }

    public void addPayment(String date, int orderID, int paymentID, String paymentAmount, String paymentMethod, int cvv, int creditnum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addPayment(int orderID, int paymentID, double paymentAmount, String paymentMethod, int cvv, String creditnum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
