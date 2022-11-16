package com.solera.bootcamp.airlinemanager.airlinemanager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class AirlineController {

	@Autowired
	private FlightRepository flightRepository;

	@PostMapping(value = "/airline/flight", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Flight>> getFlightData(@RequestBody RequestConfig requestConfig) {
		String dateStr = requestConfig.getDate();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		try {
			date = formatter.parse(dateStr);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		List<Flight> flights = flightRepository.getFlightData(date);

		if (flights.size() > 0) {
			return ResponseEntity.ok(flights);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}