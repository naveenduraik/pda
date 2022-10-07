package com.phonedirectory.app.repository;


import org.springframework.data.repository.CrudRepository;

import com.phonedirectory.app.model.Address;

public interface AddressRepository extends CrudRepository<Address,Integer> {

    
}
