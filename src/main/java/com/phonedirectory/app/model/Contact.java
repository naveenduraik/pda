package com.phonedirectory.app.model;

import jakarta.persistence.Entity;//javax persistence is renamed as jakarata.persistence
import jakarta.persistence.Id;

@Entity 
public class Contact {

    @Id
    private String contactId;
    private String countryCode;
    private String primaryMobileNumber;
    private String secondaryMobileNumber;
    private int userId;

    
    public Contact(String contactId, String countryCode,String primaryMobileNumber, String secondaryMobileNumber, int userId) {
        this.contactId = contactId;
        this.countryCode = countryCode;
        this.primaryMobileNumber = primaryMobileNumber;
        this.secondaryMobileNumber = secondaryMobileNumber;
        this.userId = userId;
    }
    public String getContactId() {
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
