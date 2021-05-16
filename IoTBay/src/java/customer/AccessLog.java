/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author Reyvaldo
 */
public class AccessLog implements Serializable{

    private int accessLogID;
    private int userID;
    private Date loginTime;
    private Date logoutTime;

    public AccessLog(int accessLogID, int userID, Date loginTime, Date logoutTime) {
        this.accessLogID = accessLogID;
        this.userID = userID;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
    }

    public int getAccessLogID() {
        return accessLogID;
    }

    public void setAccessLogID(int accessLogID) {
        this.accessLogID = accessLogID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }
    
    
}