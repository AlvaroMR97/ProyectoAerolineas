package com.solera.bootcamp.airlinemanager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class AirlineController {

	@Autowired
	private FlightRepository flightRepository;

	@PostMapping(value = "/airline/flight", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Flight>> getFlightData() {
//		String dateStr = "20/11/2022";
//		Date date = new Date();
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", new Locale("es", "ES"));
//		try {
//			date = formatter.parse(dateStr);
//		} catch (Exception e) {
//			System.out.println("Exception: " + e.getMessage());
//		}

		Integer idFlight = 0;

		List<Flight> flights = flightRepository.getFlightData(idFlight);

		if (flights.size() > 0) {
			return ResponseEntity.ok(flights);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}