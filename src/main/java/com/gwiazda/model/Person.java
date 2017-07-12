package com.gwiazda.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.BatchSize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Created by michal on 03.07.17.
 */

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person", fetch= FetchType.LAZY)
//    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @BatchSize(size=13)
//    @Fetch(FetchMode.SELECT)
//    @Fetch(FetchMode.SUBSELECT)
//    @Fetch(FetchMode.JOIN)
    private List<Address> addresses;


    public Person() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
        addresses.forEach(address -> address.setPerson(this));
    }
//    public Person(String name, String lastName) {
//        this.name = name;
//        this.lastName = lastName;
//

    public String getLastName() {
        return lastName;
    }
}
