package com.phonedirectory.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.phonedirectory.app.model.UserDetails;

public interface UserDetailsRepository extends CrudRepository<UserDetails,Integer> {

	UserDetails findByUsername(String username);
}
