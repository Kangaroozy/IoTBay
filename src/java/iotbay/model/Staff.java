/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.model;

import java.util.Date;
/**
 *
 * @author Reyvaldo
 */
public class Staff extends User{
    private Date startDate;
    private Date endDate;
    private String position;

    public Staff(int userID, String firstName, String lastName, String eMail, String password, String gender, String address, Date dateOfBirth, String phoneNumber, Date startDate, Date endDate, String position) {
        super(userID, firstName, lastName, eMail, password, gender, address, dateOfBirth, phoneNumber);
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
