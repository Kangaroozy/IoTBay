/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.io.Serializable;

/**
 *
 * @author Reyvaldo
 */
public class OrderHistory implements Serializable{
    private int orderHistoryID;
    private int userID;
    private int orderID;

    public OrderHistory(int orderHistoryID, int userID, int orderID) {
        this.orderHistoryID = orderHistoryID;
        this.userID = userID;
        this.orderID = orderID;
    }

    public int getOrderHistoryID() {
        return orderHistoryID;
    }

    public void setOrderHistoryID(int orderHistoryID) {
        this.orderHistoryID = orderHistoryID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
}