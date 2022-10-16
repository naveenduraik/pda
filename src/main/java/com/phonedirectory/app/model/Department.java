package com.phonedirectory.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
    @Id
    private String departmentId;
    private String departmentName;
    private String details;

    public Department(){

    }

    

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }



    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }



    public void setDetails(String details) {
        this.details = details;
    }



    public Department(String departmentId, String departmentName, String details) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.details = details;
    }


    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDetails() {
        return details;
    }
}
