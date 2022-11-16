package com.solera.bootcamp.airlinemanager.airlinemanager;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class FlightRepositoryImpl implements FlightRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Flight> getFlightData(Date date) {
        // TODO Implementation
    }
}