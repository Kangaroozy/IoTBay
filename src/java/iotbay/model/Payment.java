/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Reyvaldo
 */
public class Payment implements Serializable {
    private int paymentID;
    private String date;
    private String paymentMethod;
    private int orderID;
    private double paymentAmount;
    private int cvv;
    private String creditnum;
    
    public Payment(int paymentID, String date, String paymentMethod, int orderID, double paymentAmount, int cvv, String creditnum) {
        this.paymentID = paymentID;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.orderID = orderID;
        this.paymentAmount = paymentAmount;
        this.cvv = cvv;
        this.creditnum=creditnum;
    }

    public Payment(int paymentID, String date, String paymentMethod, int orderID, String paymentAmount, int cvv, String creditnum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Payment(int paymentID, String paymentMethod, int orderID, double paymentAmount, int cvv, String creditnum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    
    public int getCVV(){
        return cvv;
    }
    
    public void setCVV(int cvv){
        this.cvv=cvv;
    }
    
    public String getCreditNum(){
        return creditnum;
    }
    
    public void setCreditNum(String creditnum){
        this.creditnum=creditnum;
    }
    
}
