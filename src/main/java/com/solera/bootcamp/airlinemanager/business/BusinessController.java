package com.solera.bootcamp.airlinemanager.business;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.solera.bootcamp.airlinemanager.flight.Flight;
import com.solera.bootcamp.airlinemanager.flight.FlightRepository;
import com.solera.bootcamp.airlinemanager.origin.OriginRepository;

import jakarta.persistence.EntityNotFoundException;

//REST API
@RestController
@CrossOrigin
class BusinessController {

	private final FlightRepository flightRepository;
	private final OriginRepository originRepository;

	BusinessController(FlightRepository flightRepository, OriginRepository originRepository) {
		this.flightRepository = flightRepository;
		this.originRepository = originRepository;
	}

	// Single item
	@GetMapping("/airline/business/{idFlight}")
	BusinessLogic one(@PathVariable Integer idFlight) {

		Flight flight = flightRepository.findById(idFlight).orElseThrow(EntityNotFoundException::new);

		BusinessLogic newBusinessLogic = new BusinessLogic();

		newBusinessLogic.setAirline(flight.getAirline());
		newBusinessLogic.setOrigin(flight.getOrigin_city());
		newBusinessLogic.setScales(flight.getScales());
		newBusinessLogic.setDestination(flight.getDestination_city());
		newBusinessLogic.setFlightDate(flight.getFlight_date());

		Double priceCalc = originRepository.findByLocation(flight.getOrigin_city()).getPrice_origin();
		priceCalc += originRepository.findByLocation(flight.getDestination_city()).getPrice_destination();

		ArrayList<String> scales = flight.getScales();
		for (String scale : scales)
			priceCalc += originRepository.findByLocation(scale).getPrice_scale();

		newBusinessLogic.setFinalPrice(priceCalc);

		return newBusinessLogic;
	}

}