package com.phonedirectory.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phonedirectory.app.model.Department;
import com.phonedirectory.app.service.DepartmentService;

@RestController
public class DepartmentController {

        @Autowired
        private DepartmentService departmentService;

        @GetMapping("/departments")
        public List<Department> getAllDepartments(){
            return departmentService.getAllDepartments();
        }
        
        @GetMapping("/departments/{departmentId")
        public Optional<Department> getDepartment(@PathVariable String departmentId){
            return departmentService .getDepartment(departmentId);
        }
    
        @PostMapping("/departments")
        public void addContact(@RequestBody Department department){
                 departmentService.addDepartment(department);
        }
    
        //put or patch can be used to update the record -- but patch is best suited to update a particular field
        //in a selected record -- if we are updating the whole record then put can be used 
        //patch responds back at a lesser time line (similar to replacing a bail in cricket kit rather than replacing the whole kit bag)
        @PatchMapping("/departments/{departmentId}")
        public void updateContact(@RequestBody Department department, @PathVariable String departmentId){
            departmentService.updateDepartment(department,departmentId );
        }
    
        @DeleteMapping("/departments/{departmentId}")
        public void deleteContact(@PathVariable String departmentId){
            departmentService.deleteDepartment(departmentId);
        }      
            
        

}
