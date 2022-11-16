package com.solera.bootcamp.airlinemanager;

class PassengerNotFoundException extends RuntimeException {

	PassengerNotFoundException(Integer id) {
		super("Could not find passenger " + id);
	}
}