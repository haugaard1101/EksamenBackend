package com.example.eksamenbackend.repository;

import com.example.eksamenbackend.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface AlbumRepository extends JpaRepository<Album, Integer> {

    }
