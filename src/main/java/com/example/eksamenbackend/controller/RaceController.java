package com.example.eksamenbackend.controller;

import com.example.eksamenbackend.model.Race;
import com.example.eksamenbackend.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @CrossOrigin
    @RestController
    public class RaceController {


        @Autowired
        RaceService raceService;


        @GetMapping("/race/id/{id}")
        public Race getRaceById(@PathVariable int id) {
            return raceService.getRaceById(id);
        }

        @GetMapping("/races")
        public List<Race> getAllRaces() {
            return raceService.getAllRaces();
        }

        @PostMapping("/race")
        public ResponseEntity<Race> addRace(@RequestBody Race race) {
            return raceService.addRace(race);
        }

        @PutMapping("/race")
        public ResponseEntity<Race> updateRace(@RequestBody Race race) {
            return raceService.updateRace(race);
        }

        @DeleteMapping("/race/{id}")
        public ResponseEntity<Race> deleteRace(@PathVariable int id) {
            return raceService.deleteRace(id);
        }

    }
