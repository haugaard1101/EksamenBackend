package com.example.eksamenbackend.config;

import com.example.eksamenbackend.repository.XRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartupDataConfig implements ApplicationRunner {

    @Autowired
    XRepository xRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Starting program");





    }




}
