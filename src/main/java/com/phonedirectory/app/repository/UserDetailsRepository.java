package com.phonedirectory.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.phonedirectory.app.model.UserDetails;

public interface UserDetailsRepository extends CrudRepository<UserDetails,Integer> {

	UserDetails findByUsername(int userId);

	UserDetails findByUsername(String username);
}
