/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import java.io.PrintStream;
import java.sql.*;
import java.util.*;
import iotbay.model.Payment;
import iotbay.model.dao.*;

/**
 *
 * @author ASUS
 */
public class TestPaymentDB {
    public static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new TestPaymentDB().menu();
    }
    private DBConnector connector;
    private Connection conn;
    private DBPaymentManager manager;
    
    public TestPaymentDB() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        manager = new DBPaymentManager(conn);
    }
    
    private void testCreate() throws SQLException {
        int orderID = Integer.parseInt(read("OrderID"));
        int cvv = Integer.parseInt(read("CVV"));
        double paymentAmount = Double.parseDouble(read("paymentAmount"));
       
        System.out.println("Adding payment to the database: ");
        manager.addPayment(read("date"), orderID,paymentAmount, read("paymentMethod"),  cvv, read("creditnum"));
        System.out.println("Payment added successfully ");
    }
    
    private void testRead() throws SQLException{
        int paymentID = Integer.parseInt(read("paymentID"));
        String date = read("DATE");
        Payment payment = manager.readPayment(paymentID, date);
        String exist = (payment != null) ? "Payment exists in the database" : "Payment does not exist!!!";
        System.out.println(exist);
    }

    private void testUpdate() throws SQLException{
       int orderID = Integer.parseInt(read("OrderID"));
        int cvv = Integer.parseInt(read("CVV"));
        double paymentAmount = Integer.parseInt(read("paymentAmount"));
        int paymentID = Integer.parseInt(read("paymentID"));
        System.out.println("Adding payment to the database: ");
        manager.updatePayment(paymentID,read("paymentMethod"),orderID,paymentAmount, cvv, read("date"));
        System.out.println("Payment details updated successfully ");
    }
    
    private void testDelete() throws SQLException{
        int paymentID = Integer.parseInt(read("paymentID"));
        manager.deletePayment(paymentID);
        System.out.println("Payment deleted successfully");
    }
    
    private void testFetch() throws SQLException{
        PrintStream printf = System.out.printf("%-15s %-15s %-25s %-15s %-15s %-10s \n","paymentID","orderid", "paymentMethod", "cardnumber", "amount", "paymentdate");
        ArrayList<Payment> payments = manager.fetchPayment();
        payments.forEach(payment->System.out.printf("%-15s %-15s %-25s %-15s %-15s %-10s \n"
                + "",payment.getPaymentID(),payment.getOrderID(),payment.getPaymentMethod(),payment.getCreditNum(),payment.getPaymentAmount(),payment.getDate()));
        System.out.println();
    }
    
    private String read(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextLine();
    }
    private void menu() throws SQLException{
        char c;
        help();
        while((c=read("Command [c/r/u/d/f/x]").charAt(0)) != 'x'){
            switch(c){
                case 'c': testCreate();break;
                case 'r': testRead(); break;
                case 'u': testUpdate(); break;
                case 'd': testDelete();break;
                case 'f': testFetch();break;
                default: help(); break;
            }
        }
    }
    private void help(){
        System.out.println("Database Operations: \n"
                + "c = Create Payment \n"
                + "r = Read Payment by paymentID-date \n"
                + "u = Update Payment by paymentID \n"
                + "d = Delete Payment by paymentID\n"
                + "f = Fetch all Payments\n");
    }
}
