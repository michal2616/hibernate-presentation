package com.gwiazda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gwiazda.model.Person;

/**
 * Created by michal on 03.07.17.
 */

public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {


    List<Person> findById(long id);
}

