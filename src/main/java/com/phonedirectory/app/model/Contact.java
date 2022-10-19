package com.phonedirectory.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="contact")
public class Contact {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int contactId;
    
    private String countryCode;
    private String primaryMobileNumber;
    private String secondaryMobileNumber;
    private int userId;

    public Contact(){
        
    }
    
    public Contact(int contactId, String countryCode,String primaryMobileNumber, String secondaryMobileNumber, int userId) {
        this.contactId = contactId;
        this.countryCode = countryCode;
        this.primaryMobileNumber = primaryMobileNumber;
        this.secondaryMobileNumber = secondaryMobileNumber;
        this.userId = userId;
    }
    public int getContactId() {
        return contactId;
    }
    public String getCountryCode(){
        return countryCode;
    }
    public String getPrimaryMobileNumber() {
        return primaryMobileNumber;
    }
    public String getSecondaryMobileNumber() {
        return secondaryMobileNumber;
    }
    public int getUserId() {
        return userId;
    }

    
    
}
