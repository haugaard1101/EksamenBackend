package com.example.eksamenbackend.service;

import com.example.eksamenbackend.exception.ResourceAlreadyExistsException;
import com.example.eksamenbackend.exception.ResourceNotFoundException;
import com.example.eksamenbackend.model.AlbumCustomer;
import com.example.eksamenbackend.repository.AlbumCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumCustomerService {

    @Autowired
    AlbumCustomerRepository albumCustomerRepository;

    public AlbumCustomer getAlbumCustomerById(int id) {
        return albumCustomerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find any albumCustomer with id: " + id));
    }

    public List<AlbumCustomer> getAllAlbumCustomers() { return albumCustomerRepository.findAll();}

    public ResponseEntity<AlbumCustomer> addAlbumCustomer(AlbumCustomer albumCustomer) {
        boolean exists = albumCustomerRepository.existsById(albumCustomer.getAlbumCustomerId());
        if (exists) {
            // Hvis den existere thrower vi en exception der bliver grebet i vores exception controller og
            // lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceAlreadyExistsException("AlbumCustomer with id: " + albumCustomer.getAlbumCustomerId() + " already exists and therefore can't be added.");
        }

        // Hvis den IKKE allerede eksistere, så må vi adde den.
        AlbumCustomer newAlbumCustomer = albumCustomerRepository.save(albumCustomer);
        return new ResponseEntity<>(newAlbumCustomer, HttpStatus.OK);
    }

    public ResponseEntity<AlbumCustomer> updateAlbumCustomer(AlbumCustomer albumCustomer) {
        boolean exists = albumCustomerRepository.existsById(albumCustomer.getAlbumCustomerId());
        if (!exists) {
            // Hvis den ikke existere thrower vi en exception der bliver grebet i vores exception controller og
            // lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceNotFoundException("AlbumCustomer with id: " + albumCustomer.getAlbumCustomerId() + " does not exist and therefore can't be updated");
        }

        AlbumCustomer newAlbumCustomer = albumCustomerRepository.save(albumCustomer);
        return new ResponseEntity<>(newAlbumCustomer, HttpStatus.OK);
    }

    public ResponseEntity<AlbumCustomer> deleteAlbumCustomer(int id) {
        boolean exists = albumCustomerRepository.existsById(id);
        if (!exists) {
            // Hvis den ikke existere thrower vi en exception der bliver grebet i vores exception controller og
            // lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceNotFoundException("AlbumCustomer with id: " + id + " does not exist and therefore can't be deleted");
        }
        AlbumCustomer deletedAlbumCustomer = getAlbumCustomerById(id);
        albumCustomerRepository.deleteById(id);
        return new ResponseEntity<>(deletedAlbumCustomer, HttpStatus.OK);
    }
}
