package com.phonedirectory.app.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phonedirectory.app.model.Address;
import com.phonedirectory.app.service.AddressService;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping(method = RequestMethod.GET ,value = "/addr")
    public List<Address> getAllAddressDetails(){
        return addressService.getAllAddress();
    }

    @RequestMapping(method = RequestMethod.GET ,value = "/address/{addressId}")
    public Optional<Address> getAddress(@PathVariable int addressId){
        return addressService.getAddress(addressId);
    }

    @RequestMapping(method = RequestMethod.POST ,value = "/addr")
    public void addAddress(@RequestBody Address address){
        addressService.addAddress(address);
    }
    
    @RequestMapping(method = RequestMethod.PATCH,value="/addr/{addressId}")
    public void updateAddress(@RequestBody Address address ,@PathVariable int addressId){
        addressService.updateAddress(address, addressId);
    }

    @RequestMapping(method = RequestMethod.DELETE,value ="/addr/{addressId}")
    public void deleteAddress(@PathVariable int addressId){
        addressService.deleteAddress(addressId);
    }
}
