package com.example.eksamenbackend.controller;

import com.example.eksamenbackend.model.AlbumCustomer;
import com.example.eksamenbackend.service.AlbumCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AlbumCustomerController {


    @Autowired
    AlbumCustomerService albumCustomerService;


    @GetMapping("/albumcustomer/id/{id}")
    public AlbumCustomer getAlbumCustomerById(@PathVariable int id) {
        return albumCustomerService.getAlbumCustomerById(id);
    }

    @GetMapping("/albumcustomers")
    public List<AlbumCustomer> getAllAlbumCustomers() {
        return albumCustomerService.getAllAlbumCustomers();
    }

    @PostMapping("/albumcustomer")
    public ResponseEntity<AlbumCustomer> addAlbum(@RequestBody AlbumCustomer albumCustomer) {
        return albumCustomerService.addAlbumCustomer(albumCustomer);
    }

    @PutMapping("/albumcustomer")
    public ResponseEntity<AlbumCustomer> updateAlbumCustomer(@RequestBody AlbumCustomer albumCustomer) {
        return albumCustomerService.updateAlbumCustomer(albumCustomer);
    }

    @DeleteMapping("/albumCustomer/{id}")
    public ResponseEntity<AlbumCustomer> deleteAlbumCustomer(@PathVariable int id) {
        return albumCustomerService.deleteAlbumCustomer(id);
    }

}
