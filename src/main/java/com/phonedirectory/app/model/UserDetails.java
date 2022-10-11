package com.phonedirectory.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserDetails {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;

    @Column(name="first_name")
	private String firstName;

    @Column(name="last_name")
	private String lastName;

    @Column(name="primary_email_id")
	private String primaryEmailId;

    @Column(name="secondary_email_id")
	private String secondaryEmailId;

    @Column(name="pass_key")
	private String passKey;

    @Column(name="confirm_passkey")
	private String confirmPasskey;

    @Column(name="department_id")
	private String departmentId;

    @Column(name="designation")
	private String designation;
    
    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;
    public UserDetails(){
        
    }

    public UserDetails(int userId, String firstName, String lastName, String primaryEmailId, String secondaryEmailId,
            String passKey, String confirmPasskey, String departmentId, String designation,String username, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryEmailId = primaryEmailId;
        this.secondaryEmailId = secondaryEmailId;
        this.passKey = passKey;
        this.confirmPasskey = confirmPasskey;
        this.departmentId = departmentId;
        this.designation = designation;
        this.username=username;
        this.password=password;
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

    public String getUsername() {
    	return username;
    }
    
    public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPrimaryEmailId(String primaryEmailId) {
		this.primaryEmailId = primaryEmailId;
	}

	public void setSecondaryEmailId(String secondaryEmailId) {
		this.secondaryEmailId = secondaryEmailId;
	}

	public void setPassKey(String passKey) {
		this.passKey = passKey;
	}

	public void setConfirmPasskey(String confirmPasskey) {
		this.confirmPasskey = confirmPasskey;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
    	return password;
    }
    

}
