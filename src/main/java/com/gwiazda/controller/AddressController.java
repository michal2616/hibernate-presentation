package com.gwiazda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gwiazda.model.Address;
import com.gwiazda.repository.AddressRepository;
import com.gwiazda.specification.AddressSpecification;

/**
 * Created by us70us on 2017-07-11.
 */

@RestController
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @RequestMapping(path = "/getaddress", method = RequestMethod.GET)
    public List<Address> getone(){
        List<Address> oneAddress = addressRepository.findAll(new AddressSpecification());

        return oneAddress;
    }

}
