/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.util.Date;
/**
 *
 * @author Reyvaldo
 */
public class Staff extends User{
    private String startDate;
    private String endDate;
    private String position;

    public Staff(int userID, String firstName, String lastName, String eMail, String password, String gender, String address, String phoneNumber, String startDate, String endDate, String position) {
        super(userID, firstName, lastName, eMail, password, gender, address, phoneNumber);
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}