package com.example.eksamenbackend.service;

import com.example.eksamenbackend.exception.ResourceAlreadyExistsException;
import com.example.eksamenbackend.exception.ResourceNotFoundException;
import com.example.eksamenbackend.model.Participant;
import com.example.eksamenbackend.repository.ParticipantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    ParticipantRepository participantRepository;


    public Participant getParticipantById(int id) {
        return participantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find any participant with id: " + id));

    }

    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    public ResponseEntity<Participant> addParticipant(Participant participant) {
        boolean exists = participantRepository.existsById(participant.getParticipantId());
        if (exists) {
            // Hvis den existere thrower vi en exception der bliver grebet i vores exception controller og lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceAlreadyExistsException("Participant with id: " + participant.getParticipantId() + " already exists and therefore can't be added.");
        }

        // Hvis den IKKE allerede eksistere, så må vi adde den.
        Participant newParticipant = participantRepository.save(participant);
        return new ResponseEntity<>(newParticipant, HttpStatus.OK);
    }

    public ResponseEntity<Participant> updateParticipant(Participant participant) {

        boolean exists = participantRepository.existsById(participant.getParticipantId());
        if (!exists) {
            // Hvis den ikke existere thrower vi en exception der bliver grebet i vores exception controller og lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceNotFoundException("Participant with id: " + participant.getParticipantId() + " does not exist and therefore can't be updated");
        }

        Participant newParticipant = participantRepository.save(participant);
        return new ResponseEntity<>(newParticipant, HttpStatus.OK);
    }

    public ResponseEntity<Participant> deleteParticipant(int id) {

        boolean exists = participantRepository.existsById(id);
        if (!exists) {
            throw new ResourceNotFoundException("Participant with id: " + id + " does not exist and therefore can't be deleted");
        }
        Participant deletedParticipant = getParticipantById(id);
        participantRepository.deleteById(id);
        return new ResponseEntity<>(deletedParticipant, HttpStatus.OK);

    }

    @Transactional
    public ResponseEntity<Participant> deleteSailboat(int id) {
        boolean exists = participantRepository.existsById(id);
        if (!exists) {
            throw new ResourceNotFoundException("Participant with id: " + id + " does not exist and therefore can't be deleted");
        }
        Participant deletedParticipant = getParticipantById(id);
        participantRepository.deleteSailboatById(id);
        return new ResponseEntity<>(deletedParticipant, HttpStatus.OK);
    }

}
