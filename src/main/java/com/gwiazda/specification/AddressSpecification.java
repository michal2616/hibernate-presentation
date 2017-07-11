package com.gwiazda.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.gwiazda.model.Address;
import com.gwiazda.model.Address_;

/**
 * Created by us70us on 2017-07-11.
 */
public class AddressSpecification implements Specification<Address> {

    @Override
    public Predicate toPredicate(Root<Address> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        return cb.like(root.get(Address_.street), "%" + "Konduktorska" + "%");

    }

}
