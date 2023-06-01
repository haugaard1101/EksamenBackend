package com.example.eksamenbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int participantId;

    @ManyToOne
    @JoinColumn(name = "sailboat_id", referencedColumnName = "sailboat_id")
    // Her kalder vi vores foreign key column "sailboat_id", og værdierne den lægger ind sætter vi til at være dem der findes i referenceColumnName = "sailboat_id" variablen inde fra sailboat klassen.
    private Sailboat sailboat;

    @ManyToOne
    @JoinColumn(name = "race_id", referencedColumnName = "race_id")
    private Race race;

    private int points;


}
