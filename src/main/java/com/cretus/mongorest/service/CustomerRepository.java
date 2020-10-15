package com.cretus.mongorest.service;

import java.util.List;

import com.cretus.mongorest.entities.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,String> {
    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
    
}
