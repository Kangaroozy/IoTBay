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
    private Date date;
    private String paymentMethod;
    private int orderID;
    private double paymentAmount;

    public Payment(int paymentID, Date date, String paymentMethod, int orderID, double paymentAmount) {
        this.paymentID = paymentID;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.orderID = orderID;
        this.paymentAmount = paymentAmount;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

}
