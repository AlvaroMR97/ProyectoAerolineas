package com.solera.bootcamp.airlinemanager.flight;

class FlightNotFoundException extends RuntimeException {

	FlightNotFoundException(Integer id) {
	    super("Could not find flight " + id);
	  }
	}