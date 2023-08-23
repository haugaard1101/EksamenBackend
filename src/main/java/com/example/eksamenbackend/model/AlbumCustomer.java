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
public class AlbumCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumCustomerId;

    private boolean isReserved;

    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "album_id")
    // Her kalder vi vores foreign key column "album_id", og værdierne den lægger ind sætter vi til at være dem der findes
    // i referenceColumnName = "album_id" variablen inde fra album klassen.
    private Album album;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

}