package com.phonedirectory.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonedirectory.app.model.Department;
import com.phonedirectory.app.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;   
   

    public List<Department> getAllDepartments(){
        List<Department> departments = new ArrayList<Department>();
        departmentRepository.findAll().forEach(departments:: add);
        
        return departments;
    } 
    
    public Optional<Department> getDepartment(String departmentId){
        return departmentRepository.findById(departmentId);
     }

     public void addDepartment(Department department){
        departmentRepository.save(department);

     }

     public void updateDepartment(Department department,String departmentId){
        departmentRepository.save(department);
     }
    
     public void deleteDepartment(String departmentId){
        departmentRepository.deleteById(departmentId);
     }
}
