package com.gwiazda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gwiazda.model.Address;

/**
 * Created by us70us on 2017-07-11.
 */

public interface AddressRepository extends JpaRepository<Address, Long>, JpaSpecificationExecutor<Address> {



}
