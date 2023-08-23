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
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int storeId;

    private int zip;

    private String street;

    private String name;

    private String city;


    @OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List<Album> listOfAlbums;

}