package com.example.eksamenbackend.repository;

import com.example.eksamenbackend.model.XModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface XRepository extends JpaRepository<XModel, Integer>{

        boolean existsXModelByXXXXX(String XXXXX);

        Optional<XModel> findUserXModelByXXXXX(String XXXXX);

}
