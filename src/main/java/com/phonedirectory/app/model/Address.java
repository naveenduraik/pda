package com.phonedirectory.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {

    @Id
    private int addressId;
	private String t_doorNo;
	private String t_streetName;
	private String t_city;
	private String t_pinCode;
	private String t_state;
	private String t_country;
	private String p_doorNo;
	private String p_streetName;
	private String p_city;
	private String p_pinCode;
	private String p_state;
	private String p_country;
    private int userId;

    public Address(){

    }

    
    public Address(int addressId, String t_doorNo, String t_streetName, String t_city, String t_pinCode, String t_state,
            String t_country, String p_doorNo, String p_streetName, String p_city, String p_pinCode, String p_state,
            String p_country ,int userId) {
        this.addressId = addressId;
        this.t_doorNo = t_doorNo;
        this.t_streetName = t_streetName;
        this.t_city = t_city;
        this.t_pinCode = t_pinCode;
        this.t_state = t_state;
        this.t_country = t_country;
        this.p_doorNo = p_doorNo;
        this.p_streetName = p_streetName;
        this.p_city = p_city;
        this.p_pinCode = p_pinCode;
        this.p_state = p_state;
        this.p_country = p_country;
        this.userId = userId;
    }
    public int getAddressId() {
        return addressId;
    }
    public String getT_doorNo() {
        return t_doorNo;
    }
    public String getT_streetName() {
        return t_streetName;
    }
    public String getT_city() {
        return t_city;
    }
    public String getT_pinCode() {
        return t_pinCode;
    }
    public String getT_state() {
        return t_state;
    }
    public String getT_country() {
        return t_country;
    }
    public String getP_doorNo() {
        return p_doorNo;
    }
    public String getP_streetName() {
        return p_streetName;
    }
    public String getP_city() {
        return p_city;
    }
    public String getP_pinCode() {
        return p_pinCode;
    }
    public String getP_state() {
        return p_state;
    }
    public String getP_country() {
        return p_country;
    }
     public int getUserId() {
        return userId;
    } 

    
    
}
