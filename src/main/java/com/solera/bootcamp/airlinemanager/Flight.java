package com.solera.bootcamp.airlinemanager;

import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
class Flight {
	
	@Id
	private Integer idFlight;
	private String airline;
	private String origin_city;
	private String destination_city;
	private ArrayList<String> scales;
	private boolean luggage_allowed;
	private Date flight_date;

	public Flight(Integer idFlight, String airline, String origin_city, String destination_city, ArrayList<String> scales,
			boolean luggage_allowed, Date flight_date) {
		super();
		this.idFlight = idFlight;
		this.airline = airline;
		this.origin_city = origin_city;
		this.destination_city = destination_city;
		this.scales = scales;
		this.luggage_allowed = luggage_allowed;
		this.flight_date = flight_date;
	}
	
	public Integer getIdFlight() {
		return idFlight;
	}

	public void setIdFlight(Integer idFlight) {
		this.idFlight = idFlight;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getOrigin_city() {
		return origin_city;
	}

	public void setOrigin_city(String origin_city) {
		this.origin_city = origin_city;
	}

	public String getDestination_city() {
		return destination_city;
	}

	public void setDestination_city(String destination_city) {
		this.destination_city = destination_city;
	}

	public ArrayList<String> getScales() {
		return scales;
	}

	public void setScales(ArrayList<String> scales) {
		this.scales = scales;
	}

	public boolean isLuggage_allowed() {
		return luggage_allowed;
	}

	public void setLuggage_allowed(boolean luggage_allowed) {
		this.luggage_allowed = luggage_allowed;
	}

	public Date getFlight_date() {
		return flight_date;
	}

	public void setFlight_date(Date flight_date) {
		this.flight_date = flight_date;
	}

}
