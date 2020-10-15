package com.cretus.mongorest.resource;

import java.util.Optional;

import com.cretus.mongorest.entities.Customer;
import com.cretus.mongorest.service.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerResource {
    
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping(value = "/customers")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @GetMapping(value="/customers/{id}")
    public Optional<Customer> retrieveCustomer(@PathVariable String id){
        return customerRepository.findById(id);

    }

    @PutMapping(value ="/customers/{id}")
    public Optional<Customer> updateCustomer(@PathVariable String id) throws Exception {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer == null){
            throw new Exception(String.format("The customer with id %s is not found", id));
        }
        
        return customer;
    }
}
