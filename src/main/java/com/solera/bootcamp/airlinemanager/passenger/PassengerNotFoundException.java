package com.solera.bootcamp.airlinemanager.passenger;

class PassengerNotFoundException extends RuntimeException {

	PassengerNotFoundException(Integer id) {
		super("Could not find passenger " + id);
	}
}