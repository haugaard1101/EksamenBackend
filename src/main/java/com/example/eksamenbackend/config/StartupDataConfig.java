package com.example.eksamenbackend.config;

import com.example.eksamenbackend.model.*;
import com.example.eksamenbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StartupDataConfig implements ApplicationRunner {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AlbumCustomerRepository albumCustomerRepository;


    @Override
    public void run(ApplicationArguments args) {
        System.out.println("System start");

        createCustomers();
        List<Store> stores = createStores();

        for (Store store : stores) {
            createAlbums(store);
        }

        //    createAlbumCustomers();

    }


/*
    private void createAlbumCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        List<Album> allAlbums = albumRepository.findAll();

        AlbumCustomer newReservation = new AlbumCustomer();
        newReservation.setAlbum(allAlbums.get(1));
        newReservation.setCustomer(allCustomers.get(1));
        newReservation.setReserved(true);
        albumCustomerRepository.save(newReservation);
    }

 */

    private void createAlbums(Store store) {

        List<Album> createdAlbums = new ArrayList<>();

        Album album1 = new Album();
        album1.setTitle("Legend");
        album1.setArtist("Bob Marley and the Wailers");
        album1.setGenre("Reggea");
        album1.setAvailability("Available");
        album1.setStore(store);
        albumRepository.save(album1);
        createdAlbums.add(album1);

        Album album2 = new Album();
        album2.setTitle("Nevermind");
        album2.setArtist("Nirvana");
        album2.setGenre("Rock");
        album2.setAvailability("Not Available");
        album2.setStore(store);
        albumRepository.save(album2);
        createdAlbums.add(album2);

    }

    private List<Store> createStores() {

        List<Store> createdStores = new ArrayList<>();

        Store store1 = new Store();
        store1.setName("The Music Store");
        store1.setStreet("Rektorparken 1");
        store1.setCity("København SV");
        store1.setZip(2450);
        storeRepository.save(store1);
        createdStores.add(store1);

        return createdStores;
    }

    private List<Customer> createCustomers() {

        List<Customer> createdCustomers = new ArrayList<>();

        Customer customer1 = new Customer();
        customer1.setName("Lars");
        customer1.setEmail("Lars@email.com");
        customer1.setPhoneNumber(11223344);
        customerRepository.save(customer1);
        createdCustomers.add(customer1);


        return createdCustomers;
    }

}





