package com.example.eksamenbackend.service;

import com.example.eksamenbackend.exception.ResourceAlreadyExistsException;
import com.example.eksamenbackend.exception.ResourceNotFoundException;
import com.example.eksamenbackend.model.Race;
import com.example.eksamenbackend.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    @Autowired
    RaceRepository raceRepository;


    public Race getRaceById(int id) {
        return raceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find any race with id: " + id));

    }

    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    public ResponseEntity<Race> addRace(Race race) {
        boolean exists = raceRepository.existsById(race.getRaceId());
        if (exists) {
            // Hvis den existere thrower vi en exception der bliver grebet i vores exception controller og lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceAlreadyExistsException("Race with id: " + race.getRaceId() + " already exists and therefore can't be added.");

        }

        // Hvis den IKKE allerede eksistere, så må vi adde den.
        Race newRace = raceRepository.save(race);
        return new ResponseEntity<>(newRace, HttpStatus.OK);
    }

    public ResponseEntity<Race> updateRace(Race race) {

        boolean exists = raceRepository.existsById(race.getRaceId());
        if (!exists) {
            // Hvis den ikke existere thrower vi en exception der bliver grebet i vores exception controller og lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceNotFoundException("Race with id: " + race.getRaceId() + " does not exist and therefore can't be updated");
        }

        Race newRace = raceRepository.save(race);
        return new ResponseEntity<>(newRace, HttpStatus.OK);
    }

    public ResponseEntity<Race> deleteRace(int id) {

        boolean exists = raceRepository.existsById(id);
        if (!exists) {
            // Hvis den ikke existere thrower vi en exception der bliver grebet i vores exception controller og lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceNotFoundException("Race with id: " + id + " does not exist and therefore can't be deleted");
        }
        Race deletedRace = getRaceById(id);
        raceRepository.deleteById(id);
        return new ResponseEntity<>(deletedRace, HttpStatus.OK);

    }
}
