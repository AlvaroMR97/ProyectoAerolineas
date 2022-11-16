package com.solera.bootcamp.airlinemanager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabaseFlights(FlightRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(new Flight(0, "Madrid vuelos", "Madrid", "Barcelona",
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

}