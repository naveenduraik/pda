package com.phonedirectory.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phonedirectory.app.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,String> {
    
}
