package com.example.eksamenbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Sailboat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sailboat_id")
    private int id;

    private String type;

    private String name;

    private int points;


    @OneToMany(mappedBy = "sailboat", cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List<Participant> listOfRaces;

}
