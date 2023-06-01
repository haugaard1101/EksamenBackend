package com.example.eksamenbackend.controller;

import com.example.eksamenbackend.model.Sailboat;
import com.example.eksamenbackend.service.SailboatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SailboatController {


    @Autowired
    SailboatService sailboatService;


    @GetMapping("/sailboat/id/{id}")
    public Sailboat getSailboatById(@PathVariable int id) {
        return sailboatService.getSailboatById(id);
    }

    @GetMapping("/sailboats")
    public List<Sailboat> getAllSailboats() {
        return sailboatService.getAllSailboats();
    }

    @PostMapping("/sailboat")
    public ResponseEntity<Sailboat> addSailboat(@RequestBody Sailboat sailboat) {
        return sailboatService.addSailboat(sailboat);
    }

    @PutMapping("/sailboat")
    public ResponseEntity<Sailboat> updateSailboat(@RequestBody Sailboat sailboat) {
        return sailboatService.updateSailboat(sailboat);
    }

    @DeleteMapping("/sailboat/{id}")
    public ResponseEntity<Sailboat> deleteSailboat(@PathVariable int id) {
        return sailboatService.deleteSailboat(id);
    }

}
