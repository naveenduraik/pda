package com.phonedirectory.app.model;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class UserDetails {
    @Id
    private int userId;
	private String firstName;
	private String lastName;
	private String primaryEmailId;
	private String secondaryEmailId;
	private String passKey;
	private String confirmPasskey;
	private String departmentId;
	private String designation;

    public UserDetails(){
        
    }  

    public UserDetails(int userId, String firstName, String lastName, String primaryEmailId, String secondaryEmailId,
            String passKey, String confirmPasskey, String departmentId, String designation) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryEmailId = primaryEmailId;
        this.secondaryEmailId = secondaryEmailId;
        this.passKey = passKey;
        this.confirmPasskey = confirmPasskey;
        this.departmentId = departmentId;
        this.designation = designation;
    }


    public int getUserId() {
        return userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPrimaryEmailId() {
        return primaryEmailId;
    }
    public String getSecondaryEmailId() {
        return secondaryEmailId;
    }
    public String getPassKey() {
        return passKey;
    }
    public String getConfirmPasskey() {
        return confirmPasskey;
    }
    public String getDepartmentId() {
        return departmentId;
    }
    public String getDesignation() {
        return designation;
   } 
}
