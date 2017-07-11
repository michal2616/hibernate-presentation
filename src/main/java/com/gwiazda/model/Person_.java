package com.gwiazda.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created by us70us on 2017-07-11.
 */
@StaticMetamodel(Person.class)
public class Person_ {

        public static volatile SingularAttribute<Person, String> name;
        public static volatile SingularAttribute<Person, String> lastName;
        public static volatile ListAttribute<Person, Address> addresses;
    }
