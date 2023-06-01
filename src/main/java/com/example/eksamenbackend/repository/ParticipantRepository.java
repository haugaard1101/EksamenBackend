package com.example.eksamenbackend.repository;

import com.example.eksamenbackend.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer>{

    @Modifying
    @Query("DELETE FROM Participant p WHERE p.sailboat.id = :id")
    void deleteSailboatById(@Param("id") int id);


}
