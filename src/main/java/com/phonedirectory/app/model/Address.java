package com.phonedirectory.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int addressId;
	private String tDoorNo;
	private String tStreetName;
	private String tCity;
	private String tPinCode;
	private String tState;
	private String tCountry;
	private String pDoorNo;
	private String pStreetName;
	private String pCity;
	private String pPinCode;
	private String pState;
	private String pCountry;
    private int userId;

    
    public Address(){
        
    }

    
    public Address(int addressId, String tDoorNo, String tStreetName, String tCity, String tPinCode, String tState,
            String tCountry, String pDoorNo, String pStreetName, String pCity, String pPinCode, String pState,
            String pCountry, int userId) {
        this.addressId = addressId;
        this.tDoorNo = tDoorNo;
        this.tStreetName = tStreetName;
        this.tCity = tCity;
        this.tPinCode = tPinCode;
        this.tState = tState;
        this.tCountry = tCountry;
        this.pDoorNo = pDoorNo;
        this.pStreetName = pStreetName;
        this.pCity = pCity;
        this.pPinCode = pPinCode;
        this.pState = pState;
        this.pCountry = pCountry;
        this.userId = userId;
    }




    public int getAddressId() {
        return addressId;
    }




    public String gettDoorNo() {
        return tDoorNo;
    }




    public String gettStreetName() {
        return tStreetName;
    }




    public String gettCity() {
        return tCity;
    }




    public String gettPinCode() {
        return tPinCode;
    }




    public String gettState() {
        return tState;
    }




    public String gettCountry() {
        return tCountry;
    }




    public String getpDoorNo() {
        return pDoorNo;
    }




    public String getpStreetName() {
        return pStreetName;
    }




    public String getpCity() {
        return pCity;
    }




    public String getpPinCode() {
        return pPinCode;
    }




    public String getpState() {
        return pState;
    }




    public String getpCountry() {
        return pCountry;
    }




    public int getUserId() {
        return userId;
    }

    

    
    

    
    
}
