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
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private int albumId;

    private String title;

    private String artist;

    private String genre;

    private boolean availability;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    // Her kalder vi vores foreign key column "store_id", og værdierne den lægger ind sætter vi til at være dem der findes i referenceColumnName = "store_id" variablen inde fra store klassen.
    private Store store;

    @OneToMany(mappedBy = "album", cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List<AlbumCustomer> listOfAlbumCustomers;


}

