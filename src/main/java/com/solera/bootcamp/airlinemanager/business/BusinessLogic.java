package com.solera.bootcamp.airlinemanager.business;

import java.util.ArrayList;
import java.util.Date;

public class BusinessLogic {

	private String airline;
	private Double finalPrice;
	private String origin;
	private ArrayList<String> scales;
	private String destination;
	private Date flightDate;

	public BusinessLogic() {
	}

	public BusinessLogic(String airline, Double finalPrice, String origin, ArrayList<String> scales,
			String destination, Date flightDate) {
		super();
		this.airline = airline;
		this.finalPrice = finalPrice;
		this.origin = origin;
		this.scales = scales;
		this.destination = destination;
		this.flightDate = flightDate;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public ArrayList<String> getScales() {
		return scales;
	}

	public void setScales(ArrayList<String> scales) {
		this.scales = scales;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

}
