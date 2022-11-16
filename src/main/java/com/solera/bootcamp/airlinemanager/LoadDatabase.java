package com.solera.bootcamp.airlinemanager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.solera.bootcamp.airlinemanager.flight.Flight;
import com.solera.bootcamp.airlinemanager.flight.FlightRepository;
import com.solera.bootcamp.airlinemanager.origin.Origin;
import com.solera.bootcamp.airlinemanager.origin.OriginRepository;
import com.solera.bootcamp.airlinemanager.passenger.Passenger;
import com.solera.bootcamp.airlinemanager.passenger.PassengerRepository;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabaseFlights(FlightRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(new Flight(0, "Madrid Vuelos", "Madrid, España", "Paris, Francia",
					new ArrayList<String>(), true, new SimpleDateFormat("ddMMyyyy").parse("20112022"))));
		};
	}

	@Bean
	CommandLineRunner initDatabasePassengers(PassengerRepository repository) {

		return args -> {
			log.info("Preloading "
					+ repository.save(new Passenger(0, "12345678A", "David", "Lopez Chica", "España", 28)));
		};
	}

	@Bean
	CommandLineRunner initDatabaseOrigins(OriginRepository repository) {

		return args -> {
			log.info("Preloading "
					+ repository.save(new Origin(0, "Madrid, España", 32d, 10d, 24d, 'B')));
		};
	}

}