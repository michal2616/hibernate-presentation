package com.gwiazda.specification;

import static com.gwiazda.HibernateEmptyApplication.JANUSZ;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.gwiazda.model.Person;
import com.gwiazda.model.Person_;

/**
 * Created by us70us on 2017-07-11.
 */
public class PersonSpecification implements Specification<Person> {

    @Override
    public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

//        Join<Person, Address> joiner = root.join(Person_.addresses);
//        return cb.like(joiner.get(Address_.street), "%" + "Konduktorska1" + "%");
        return cb.like(root.get(Person_.name), "%" + JANUSZ + "%");


//    public static Specification<Person> getPeople() {
//        return new Specification<Person>() {
//            public Predicate toPredicate(Root<T> root, CriteriaQuery query, CriteriaBuilder cb) {
//                return cb.equal(root.get(Person_.name), "asa");
//            }
//        };
//    }

    }
}
