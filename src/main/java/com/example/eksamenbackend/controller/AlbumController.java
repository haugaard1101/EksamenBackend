package com.example.eksamenbackend.controller;

import com.example.eksamenbackend.model.Album;
import com.example.eksamenbackend.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AlbumController {


    @Autowired
    AlbumService albumService;


    @GetMapping("/album/id/{id}")
    public Album getAlbumById(@PathVariable int id) {
        return albumService.getAlbumById(id);
    }

    @GetMapping("/albums")
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @PostMapping("/album")
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        return albumService.addAlbum(album);
    }

    @PutMapping("/album")
    public ResponseEntity<Album> updateAlbum(@RequestBody Album album) {
        return albumService.updateAlbum(album);
    }

    @DeleteMapping("/album/{id}")
    public ResponseEntity<Album> deleteAlbum(@PathVariable int id) {
        return albumService.deleteAlbum(id);
    }

}