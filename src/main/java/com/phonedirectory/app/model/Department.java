package com.phonedirectory.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Department {
    @Id
    private String departmentId;
    private String departmentName;
    private String details;

    public Department(){

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
