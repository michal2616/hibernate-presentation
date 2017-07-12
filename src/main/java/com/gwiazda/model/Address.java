package com.gwiazda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * Created by us70us on 2017-07-05.
 */

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Address {
    public Address() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String city;

    public void setId(long id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    private String street;
    private int nr;
    private String postalCode;


//without it it json will kill your memory
    @JsonIgnore
    public Person getPerson() {
        return person;
    }

    @ManyToOne
    @JoinColumn(name = "person_fk")
    private Person person;
}
