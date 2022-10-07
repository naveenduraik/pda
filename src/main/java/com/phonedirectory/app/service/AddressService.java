package com.phonedirectory.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonedirectory.app.model.Address;
import com.phonedirectory.app.repository.AddressRepository;

@Service

public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    private List<Address> addressList = new ArrayList<Address>(Arrays.asList(
        new Address(1,"sada","adad","asda","asd","asda","asda","asda","asda","adsa","asda","asda","as",1),
        new Address(2,"sada","adad","asda","asd","asda","asda","asda","asda","adsa","asda","asda","as",2)
    ));
    public List<Address> getAllAddress(){
        List<Address> addressList = new ArrayList<Address>();
        addressRepository.findAll().forEach(addressList :: add);
        return addressList;
    }

    public Optional<Address> getAddress(int addressId){
        return addressRepository.findById(addressId);
    }
    
    public void addAddress(Address address){
        addressRepository.save(address);
    }

    public void updateAddress(Address address ,int addressId){
        addressRepository.save(address);
    }
    public void deleteAddress(int addressId){
        addressRepository.deleteById(addressId);
    }
}
