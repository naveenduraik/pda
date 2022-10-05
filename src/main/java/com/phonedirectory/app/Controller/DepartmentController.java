package com.phonedirectory.app.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

        @RequestMapping(method = RequestMethod.GET,value ="/departments")
        public List<Department> getAllDepartments(){
            return departmentService.getAllDepartments();
        }
        
        @RequestMapping(method = RequestMethod.GET,value ="/departments/{departmentId}")
        public Optional<Department> getDepartment(@PathVariable String departmentId){
            return departmentService .getDepartment(departmentId);
        }
    
        @RequestMapping(method = RequestMethod.POST,value = "/departments")
        public void addContact(@RequestBody Department department){
                 departmentService.addDepartment(department);
        }
    
        //put or patch can be used to update the record -- but patch is best suited to update a particular field
        //in a selected record -- if we are updating the whole record then put can be used 
        //patch responds back at a lesser time line (similar to replacing a bail in cricket kit rather than replacing the whole kit bag)
        @RequestMapping(method = RequestMethod.PATCH,value="/departments/{departmentId}")
        public void updateContact(@RequestBody Department department, @PathVariable String departmentId){
            departmentService.updateDepartment(department,departmentId );
        }
    
        @RequestMapping(method = RequestMethod.DELETE,value ="/departments/{departmentId}")
        public void deleteContact(@PathVariable String departmentId){
            departmentService.deleteDepartment(departmentId);
        }      
            
        

}
