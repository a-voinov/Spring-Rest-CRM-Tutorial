package com.tutorial.springdemo.rest;

import com.tutorial.springdemo.entity.Customer;
import com.tutorial.springdemo.exception.CustomerNotFoundException;
import com.tutorial.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    //autowire the Customer Service
    @Autowired
    private CustomerService customerService;

    //add mapping for GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    //add mapping for GET /customers/{customerId}
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null)
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        return customer;
    }

    //add mapping for POST /customers - add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        //set id to 0 in case the pass of id in JSON
        //for saveOrUpdate() Hibernate method
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

}
