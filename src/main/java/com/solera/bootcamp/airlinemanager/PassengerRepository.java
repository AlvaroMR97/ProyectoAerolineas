package com.solera.bootcamp.airlinemanager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, String> {
    List<Passenger> getPassengerData(String idDocument);
}