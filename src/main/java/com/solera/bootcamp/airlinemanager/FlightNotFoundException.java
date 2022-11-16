package com.solera.bootcamp.airlinemanager;

class FlightNotFoundException extends RuntimeException {

	FlightNotFoundException(Integer id) {
	    super("Could not find flight " + id);
	  }
	}