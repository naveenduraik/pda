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
import org.springframework.web.bind.annotation.RestController;

import com.phonedirectory.app.model.Address;
import com.phonedirectory.app.service.AddressService;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public List<Address> getAllAddressDetails(){
        return addressService.getAllAddress();
    }

    @GetMapping("/address/{addressId}")
    public Optional<Address> getAddress(@PathVariable int addressId){
        return addressService.getAddress(addressId);
    }

    @PostMapping("/address")
    public void addAddress(@RequestBody Address address){
        addressService.addAddress(address);
    }
    
    @PatchMapping("/address/{addressId}")
    public void updateAddress(@RequestBody Address address ,@PathVariable int addressId){
        addressService.updateAddress(address, addressId);
    }

    @DeleteMapping("/address/{addressId}")
    public void deleteAddress(@PathVariable int addressId){
        addressService.deleteAddress(addressId);
    }
}
