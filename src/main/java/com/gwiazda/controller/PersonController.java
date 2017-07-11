package com.gwiazda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gwiazda.model.Address;
import com.gwiazda.model.Person;
import com.gwiazda.repository.PersonRepository;
import com.gwiazda.service.PersonService;
import com.gwiazda.specification.PersonSpecification;

/**
 * Created by us70us on 2017-07-05.
 */

@RestController
public class PersonController {


    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

        @RequestMapping(path = "/getall", method = RequestMethod.GET)
        public List<Person> getAllPeople(){
            List<Person> allPeople = personRepository.findAll();
            List<Address> adrress = allPeople.get(0).getAddresses();
            return allPeople;
        }

    @RequestMapping(path = "/getall/{id}", method = RequestMethod.GET)
    public List<Person> getById(@PathVariable("id") String id){
        List<Person> allPeople = personRepository.findById(Long.valueOf(id));

        return allPeople;
    }

    @RequestMapping(path = "/getallspec", method = RequestMethod.GET)
    public List<Person> getone(){
        List<Person> onePeople = personRepository.findAll(new PersonSpecification());

        return onePeople;
    }

    @RequestMapping(path = "/getall/logs", method = RequestMethod.GET)
    public String getAllLogs(){

        personService.showPeople();
        return "egeszege";
    }



}
