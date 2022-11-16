package com.solera.bootcamp.airlinemanager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

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
			log.info("Preloading " + repository.save(new Flight(0, "Madrid Vuelos", "Madrid, España", "New York, EEUU",
					new ArrayList<>(), true, new SimpleDateFormat("ddMMyyyyhh").parse("2111202216"))));
			log.info("Preloading " + repository.save(new Flight(1, "American Flights", "New York, EEUU", "Paris, Francia",
					new ArrayList<>(Arrays.asList("Madrid, España")), true, new SimpleDateFormat("ddMMyyyyhh").parse("2011202215"))));
			log.info("Preloading " + repository.save(new Flight(2, "American Flights", "New York, EEUU", "Berlin, Alemania",
					new ArrayList<>(Arrays.asList("Madrid, España", "Paris, Francia")), true, new SimpleDateFormat("ddMMyyyyhh").parse("2211202218"))));
			log.info("Preloading " + repository.save(new Flight(3, "Paris Airline", "Paris, Francia", "Buenos Aires, Argentina",
					new ArrayList<>(Arrays.asList("Madrid, España")), true, new SimpleDateFormat("ddMMyyyyhh").parse("2311202216"))));
			log.info("Preloading " + repository.save(new Flight(4, "Achtung Trips", "Berlin, Alemania", "Paris, Francia",
					new ArrayList<>(), true, new SimpleDateFormat("ddMMyyyyhh").parse("2511202214"))));
			log.info("Preloading " + repository.save(new Flight(5, "Achtung Trips", "Berlin, Alemania", "Buenos Aires, Argentina",
					new ArrayList<>(Arrays.asList("Paris, Francia", "Madrid, España")), true, new SimpleDateFormat("ddMMyyyyhh").parse("2411202213"))));
			log.info("Preloading " + repository.save(new Flight(6, "Buenos Vuelos", "Buenos Aires, Argentina", "Berlin, Alemania",
					new ArrayList<>(Arrays.asList("Madrid, España", "Paris, Francia")), true, new SimpleDateFormat("ddMMyyyyhh").parse("2411202212"))));
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
					+ repository.save(new Origin(0, "Madrid, España", 27d, 11d, 31d, 'B')));
			log.info("Preloading "
					+ repository.save(new Origin(1, "Paris, Francia", 23d, 10d, 25d, 'C')));
			log.info("Preloading "
					+ repository.save(new Origin(2, "Berlin, Alemania", 25d, 9d, 27d, 'D')));
			log.info("Preloading "
					+ repository.save(new Origin(3, "New York, EEUU", 34d, 12d, 44d, 'A')));
			log.info("Preloading "
					+ repository.save(new Origin(4, "Buenos Aires, Argentina", 21d, 6d, 22d, 'A')));
		};
	}

}