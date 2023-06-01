package com.example.eksamenbackend.config;

import com.example.eksamenbackend.model.Race;
import com.example.eksamenbackend.model.Sailboat;
import com.example.eksamenbackend.model.Participant;
import com.example.eksamenbackend.repository.RaceRepository;
import com.example.eksamenbackend.repository.SailboatRepository;
import com.example.eksamenbackend.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StartupDataConfig implements ApplicationRunner {

    @Autowired
    RaceRepository raceRepository;
    @Autowired
    SailboatRepository sailboatRepository;
    @Autowired
    ParticipantRepository participantRepository;


    @Override
    public void run(ApplicationArguments args) {
        System.out.println("System start");

        createRaces();
        List<Sailboat> sailboats = createSailboats();

        for (Sailboat sailboat : sailboats) {
            createParticipants(sailboat);
        }
    }

    private List<Race> createRaces() {
        List<Race> createdRaces = new ArrayList<>();

        Race firstRace = new Race();
        firstRace.setDate("10/05/23");
        raceRepository.save(firstRace);
        createdRaces.add(firstRace);

        Race secondRace = new Race();
        secondRace.setDate("07/06/23");
        raceRepository.save(secondRace);
        createdRaces.add(secondRace);

        Race thirdRace = new Race();
        thirdRace.setDate("05/07/23");
        raceRepository.save(thirdRace);
        createdRaces.add(thirdRace);

        return createdRaces;
    }

    private List<Sailboat> createSailboats() {
        List<Sailboat> createdSailboats = new ArrayList<>();
        // Over 40 feet //
        Sailboat bigBoat1 = new Sailboat();
        bigBoat1.setType("Over40");
        bigBoat1.setName("Berta");
        bigBoat1.setPoints(1);
        sailboatRepository.save(bigBoat1);
        createdSailboats.add(bigBoat1);

        Sailboat bigBoat2 = new Sailboat();
        bigBoat2.setType("Over40");
        bigBoat2.setName("Emma");
        bigBoat2.setPoints(2);
        sailboatRepository.save(bigBoat2);
        createdSailboats.add(bigBoat2);

        // 25-40 feet //
        Sailboat mediumBoat1 = new Sailboat();
        mediumBoat1.setType("Between25And40");
        mediumBoat1.setName("Freya");
        mediumBoat1.setPoints(3);
        sailboatRepository.save(mediumBoat1);
        createdSailboats.add(mediumBoat1);

        Sailboat mediumBoat2 = new Sailboat();
        mediumBoat2.setType("Between25And40");
        mediumBoat2.setName("Sally");
        mediumBoat2.setPoints(2);
        sailboatRepository.save(mediumBoat2);
        createdSailboats.add(mediumBoat2);

        // Under 25 feet //
        Sailboat smallBoat1 = new Sailboat();
        smallBoat1.setType("Under25");
        smallBoat1.setName("Sandy");
        smallBoat1.setPoints(6);
        sailboatRepository.save(smallBoat1);
        createdSailboats.add(smallBoat1);

        Sailboat smallBoat2 = new Sailboat();
        smallBoat2.setType("Under25");
        smallBoat2.setName("Ella");
        smallBoat2.setPoints(3);
        sailboatRepository.save(smallBoat2);
        createdSailboats.add(smallBoat2);

        return createdSailboats;
    }

    private void createParticipants(Sailboat sailboat) {
        List<Race> allRaces = raceRepository.findAll();

        Participant firstRaceParticipant = new Participant();
        firstRaceParticipant.setSailboat(sailboat);
        firstRaceParticipant.setRace(allRaces.get(0));
        firstRaceParticipant.setPoints(sailboat.getPoints()*2);
        participantRepository.save(firstRaceParticipant);

        Participant secondRaceParticipant = new Participant();
        secondRaceParticipant.setSailboat(sailboat);
        secondRaceParticipant.setRace(allRaces.get(1));
        secondRaceParticipant.setPoints(firstRaceParticipant.getPoints()*2);
        participantRepository.save(secondRaceParticipant);

        Participant thirdRaceParticipant = new Participant();
        thirdRaceParticipant.setSailboat(sailboat);
        thirdRaceParticipant.setRace(allRaces.get(2));
        thirdRaceParticipant.setPoints(secondRaceParticipant.getPoints()*2);
        participantRepository.save(thirdRaceParticipant);

    }

}





