package com.phonedirectory.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
    @Id   
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    //@Column(name="department_id")
    private String departmentId;

    //@Column(name="department_name")
    private String departmentName;

    private String details;

    public Department(){

    }

    public Department(int id, String departmentId, String departmentName, String details) {
        this.id = id;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.details = details;
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



    public int getId() {
        return id;
    }
}
