package com.solera.bootcamp.airlinemanager;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
class AirlineController {

  private final FlightRepository flightRepository;
  private final PassengerRepository passengerRepository;

  AirlineController(FlightRepository flightRepository, PassengerRepository passengerRepository) {
    this.flightRepository = flightRepository;
    this.passengerRepository = passengerRepository;
  }

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/airline/flights")
  List<Flight> all() {
    return flightRepository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/airline/flights")
  Flight newFlight(@RequestBody Flight newFlight) {
    return flightRepository.save(newFlight);
  }

  // Single item
  @GetMapping("/airline/flights/{idFlight}")
  Flight one(@PathVariable Integer idFlight) {
    
    return flightRepository.findById(idFlight)
      .orElseThrow(() -> new FlightNotFoundException(idFlight));
  }

  @PutMapping("/airline/flights/{idFlight}")
  Flight replaceFlight(@RequestBody Flight newFlight, @PathVariable Integer idFlight) {
    
    return flightRepository.findById(idFlight)
      .map(flight -> {
    	  flight.setAirline(newFlight.getAirline());
    	  flight.setOrigin_city(newFlight.getOrigin_city());
    	  flight.setDestination_city(newFlight.getDestination_city());
    	  flight.setScales(newFlight.getScales());
    	  flight.setLuggage_allowed(newFlight.isLuggage_allowed());
    	  flight.setFlight_date(newFlight.getFlight_date());
        return flightRepository.save(flight);
      })
      .orElseGet(() -> {
        newFlight.setIdFlight(idFlight);
        return flightRepository.save(newFlight);
      });
  }

  @DeleteMapping("/airline/flights/{idFlight}")
  void deleteEmployee(@PathVariable Integer idFlight) {
    flightRepository.deleteById(idFlight);
  }
}