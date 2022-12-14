package com.solera.bootcamp.airlinemanager.passenger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class PassengerNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(PassengerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String passengerNotFoundHandler(PassengerNotFoundException ex) {
		return ex.getMessage();
	}
}