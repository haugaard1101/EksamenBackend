package com.example.eksamenbackend.service;

import com.example.eksamenbackend.exception.ResourceAlreadyExistsException;
import com.example.eksamenbackend.exception.ResourceNotFoundException;
import com.example.eksamenbackend.model.Customer;
import com.example.eksamenbackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerSevice {
    @Autowired
    CustomerRepository customerRepository;


    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find any Customer with id: " + id));
    }

    public List<Customer> getAllCustomers() { return customerRepository.findAll();}

    public ResponseEntity<Customer> addCustomer(Customer customer) {
        boolean exists = customerRepository.existsById(customer.getCustomerId());
        if (exists) {
            // Hvis den existere thrower vi en exception der bliver grebet i vores exception controller og
            // lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceAlreadyExistsException("Customer with id: " + customer.getCustomerId() + " already exists and therefore can't be added.");
        }

        // Hvis den IKKE allerede eksistere, så må vi adde den.
        Customer newCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }

    public ResponseEntity<Customer> updateCustomer(Customer customer) {
        boolean exists = customerRepository.existsById(customer.getCustomerId());
        if (!exists) {
            // Hvis den ikke existere thrower vi en exception der bliver grebet i vores exception controller og
            // lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceNotFoundException("Customer with id: " + customer.getCustomerId() + " does not exist and therefore can't be updated");
        }

        Customer newCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }

    public ResponseEntity<Customer> deleteCustomer(int id) {
        boolean exists = customerRepository.existsById(id);
        if (!exists) {
            // Hvis den ikke existere thrower vi en exception der bliver grebet i vores exception controller og
            // lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceNotFoundException("Customer with id: " + id + " does not exist and therefore can't be deleted");
        }
        Customer deletedCustomer = getCustomerById(id);
        customerRepository.deleteById(id);
        return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
    }
}

