package com.phonedirectory.app.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.phonedirectory.app.model.Contact;

public interface ContactRepository extends CrudRepository<Contact,Integer>  {
	
	 @Query(value = "SELECT ud.username,c.primary_mobile_number FROM pdaboot.user_details ud inner join pdaboot.contact c on ud.user_id=c.user_id where ud.user_id=:userId",nativeQuery = true)
	   public String userDetailsPhone(@RequestParam("userId") int userId);
	 
	 @Query(value = "SELECT ud.username,c.primary_mobile_number FROM pdaboot.user_details ud inner join pdaboot.contact c on ud.user_id=c.user_id where ud.username=:username",nativeQuery = true)
	   public String usernameDetailsPhone(@RequestParam("username") String username);
}

