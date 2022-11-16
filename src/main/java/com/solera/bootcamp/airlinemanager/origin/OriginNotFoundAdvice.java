package com.solera.bootcamp.airlinemanager.origin;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class OriginNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(OriginNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String originNotFoundHandler(OriginNotFoundException ex) {
		return ex.getMessage();
	}
}