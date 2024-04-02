package com.iu.rokala.primesservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iu.rokala.primesservice.model.Customer;

@Repository
public interface AuthenticationDBRepository extends CrudRepository<Customer, String> {
	
	Customer findByUsername(String username);

}
