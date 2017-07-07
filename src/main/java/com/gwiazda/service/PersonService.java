package com.gwiazda.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwiazda.model.Person;
import com.gwiazda.repository.PersonRepository;

/**
 * Created by us70us on 2017-07-06.
 */
@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository personRepository;


    PersonService(){

    }
    public void showPeople(){
        List<Person> allGuys = personRepository.findAll();

        System.out.println(allGuys.get(0).getAddresses());
        System.out.println("bam");
    }
}
