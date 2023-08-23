package com.example.eksamenbackend.controller;

import com.example.eksamenbackend.model.Customer;
import com.example.eksamenbackend.service.CustomerSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CustomerController {


    @Autowired
    CustomerSevice customerSevice;


    @GetMapping("/customer/id/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerSevice.getCustomerById(id);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerSevice.getAllCustomers();
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return customerSevice.addCustomer(customer);
    }

    @PutMapping("/customer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        return customerSevice.updateCustomer(customer);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable int id) {
        return customerSevice.deleteCustomer(id);
    }

}
