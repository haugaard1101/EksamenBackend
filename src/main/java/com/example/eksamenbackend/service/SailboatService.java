package com.example.eksamenbackend.service;

import com.example.eksamenbackend.exception.ResourceAlreadyExistsException;
import com.example.eksamenbackend.exception.ResourceNotFoundException;
import com.example.eksamenbackend.model.Sailboat;
import com.example.eksamenbackend.repository.SailboatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SailboatService {


    @Autowired
    SailboatRepository sailboatRepository;


    public Sailboat getSailboatById(int id) {
        return sailboatRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find any sailboat with id: " + id));

    }

    public List<Sailboat> getAllSailboats() {
        return sailboatRepository.findAll();
    }

    public ResponseEntity<Sailboat> addSailboat(Sailboat sailboat) {
        boolean exists = sailboatRepository.existsById(sailboat.getId());
        if (exists) {
            // Hvis den existere thrower vi en exception der bliver grebet i vores exception controller og lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceAlreadyExistsException("Sailboat with id: " + sailboat.getId() + " already exists and therefore can't be added.");
        }

        // Hvis den IKKE allerede eksistere, så må vi adde den.
        Sailboat newSailboat = sailboatRepository.save(sailboat);
        return new ResponseEntity<>(newSailboat, HttpStatus.OK);
    }

    public ResponseEntity<Sailboat> updateSailboat(Sailboat sailboat) {

        boolean exists = sailboatRepository.existsById(sailboat.getId());
        if (!exists) {
            // Hvis den ikke existere thrower vi en exception der bliver grebet i vores exception controller og lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceNotFoundException("Sailboat with id: " + sailboat.getId() + " does not exist and therefore can't be updated");
        }

        Sailboat newSailboat = sailboatRepository.save(sailboat);
        return new ResponseEntity<>(newSailboat, HttpStatus.OK);
    }

    public ResponseEntity<Sailboat> deleteSailboat(int id) {

        boolean exists = sailboatRepository.existsById(id);
        if (!exists) {
            // Hvis den ikke existere thrower vi en exception der bliver grebet i vores exception controller og lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceNotFoundException("Sailboat with id: " + id + " does not exist and therefore can't be deleted");
        }
        Sailboat deletedSailboat = getSailboatById(id);
        sailboatRepository.deleteById(id);
        return new ResponseEntity<>(deletedSailboat, HttpStatus.OK);

    }
}
