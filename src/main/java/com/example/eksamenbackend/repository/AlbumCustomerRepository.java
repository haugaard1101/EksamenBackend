package com.example.eksamenbackend.repository;

import com.example.eksamenbackend.model.AlbumCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumCustomerRepository extends JpaRepository<AlbumCustomer, Integer> {
}
