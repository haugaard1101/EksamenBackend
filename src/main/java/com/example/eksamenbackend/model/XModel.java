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
    @Table(name = "XXXXXXX")
    public class XModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "XXXXXXXX")
        private int id;

        private String name;

        @Column(unique = true)
        private String email;

        @Column(nullable = false)
        private String phoneNumber;

        private String password;
/*
        @OneToMany(mappedBy = "bookingUserProfile", cascade = CascadeType.REMOVE)
        @JsonBackReference
        private List<XXXXX> XModelListOfXXXXXX;
 */


}
