package com.example.eksamenbackend.service;

import com.example.eksamenbackend.exception.ResourceAlreadyExistsException;
import com.example.eksamenbackend.exception.ResourceNotFoundException;
import com.example.eksamenbackend.model.Album;
import com.example.eksamenbackend.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;


    public Album getAlbumById(int id) {
        return albumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find any album with id: " + id));
    }

    public List<Album> getAllAlbums() { return albumRepository.findAll();}

    public ResponseEntity<Album> addAlbum(Album album) {
        boolean exists = albumRepository.existsById(album.getAlbumId());
        if (exists) {
            // Hvis den existere thrower vi en exception der bliver grebet i vores exception controller og
            // lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceAlreadyExistsException("Album with id: " + album.getAlbumId() + " already exists and therefore can't be added.");
        }

        // Hvis den IKKE allerede eksistere, så må vi adde den.
        Album newAlbum = albumRepository.save(album);
        return new ResponseEntity<>(newAlbum, HttpStatus.OK);
    }

    public ResponseEntity<Album> updateAlbum(Album album) {
        boolean exists = albumRepository.existsById(album.getAlbumId());
        if (!exists) {
            // Hvis den ikke existere thrower vi en exception der bliver grebet i vores exception controller og
            // lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceNotFoundException("Album with id: " + album.getAlbumId() + " does not exist and therefore can't be updated");
        }

        Album newAlbum = albumRepository.save(album);
        return new ResponseEntity<>(newAlbum, HttpStatus.OK);
    }

    public ResponseEntity<Album> deleteAlbum(int id) {
        boolean exists = albumRepository.existsById(id);
        if (!exists) {
            // Hvis den ikke existere thrower vi en exception der bliver grebet i vores exception controller og
            // lavet til et responseEntity object, som vores frontend også kan håndtere.
            throw new ResourceNotFoundException("Album with id: " + id + " does not exist and therefore can't be deleted");
        }
        Album deletedAlbum = getAlbumById(id);
        albumRepository.deleteById(id);
        return new ResponseEntity<>(deletedAlbum, HttpStatus.OK);
    }
}
