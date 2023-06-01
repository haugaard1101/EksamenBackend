package com.example.eksamenbackend.repository;

import com.example.eksamenbackend.model.Sailboat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SailboatRepository extends JpaRepository<Sailboat, Integer>{

}
