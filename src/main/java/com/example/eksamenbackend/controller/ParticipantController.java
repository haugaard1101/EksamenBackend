package com.example.eksamenbackend.controller;

import com.example.eksamenbackend.model.Participant;
import com.example.eksamenbackend.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @CrossOrigin
    @RestController
    public class ParticipantController {


        @Autowired
        ParticipantService participantService;

        //opg 2d
        @DeleteMapping("/participant/sailboatid/{id}")
        public ResponseEntity<Participant> deleteSailboat(@PathVariable int id) {
            return participantService.deleteSailboat(id);
        }

        @GetMapping("/participant/id/{id}")
        public Participant getParticipantById(@PathVariable int id) {
            return participantService.getParticipantById(id);
        }

        @GetMapping("/participants")
        public List<Participant> getAllParticipants() {
            return participantService.getAllParticipants();
        }

        @PostMapping("/participant")
        public ResponseEntity<Participant> addParticipant(@RequestBody Participant participant) {
            return participantService.addParticipant(participant);
        }

        @PutMapping("/participant")
        public ResponseEntity<Participant> updateParticipant(@RequestBody Participant participant) {
            return participantService.updateParticipant(participant);
        }

        @DeleteMapping("/participant/{id}")
        public ResponseEntity<Participant> deleteParticipant(@PathVariable int id) {
            return participantService.deleteParticipant(id);
        }

    }
