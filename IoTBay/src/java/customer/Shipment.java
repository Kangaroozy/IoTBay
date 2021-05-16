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
 * @author Admin
 */
public class Shipment implements Serializable{
    private int shipmentID;
    private String shipmentAddress;
    private String unitNumber;
    private String streetName;
    private String suburb;
    private String postCode;
    private String state;
    private Date shipmentDate;

    public Shipment(int shipmentID, String shipmentAddress, String unitNumber, String streetName, String suburb, String postCode, String state, Date shipmentDate) {
        this.shipmentID = shipmentID;
        this.shipmentAddress = shipmentAddress;
        this.unitNumber = unitNumber;
        this.streetName = streetName;
        this.suburb = suburb;
        this.postCode = postCode;
        this.state = state;
        this.shipmentDate = shipmentDate;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }

    public String getShipmentAddress() {
        return shipmentAddress;
    }

    public void setShipmentAddress(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

}