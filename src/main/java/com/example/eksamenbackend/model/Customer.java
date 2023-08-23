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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    private String email;

    private String name;

    private int phoneNumber;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    @JsonBackReference
    private List<AlbumCustomer> listOfAlbumCustomers;


}