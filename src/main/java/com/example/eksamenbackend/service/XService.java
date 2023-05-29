package com.example.eksamenbackend.service;

import com.example.eksamenbackend.repository.XRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XService {

    @Autowired
    XRepository xRepository;


}
