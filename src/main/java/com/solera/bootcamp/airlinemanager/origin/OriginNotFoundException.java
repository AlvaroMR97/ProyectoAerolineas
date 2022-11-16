package com.solera.bootcamp.airlinemanager.origin;

class OriginNotFoundException extends RuntimeException {

	OriginNotFoundException(Integer id) {
		super("Could not find origin " + id);
	}
}