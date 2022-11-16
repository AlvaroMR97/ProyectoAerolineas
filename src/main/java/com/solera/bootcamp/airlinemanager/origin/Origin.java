package com.solera.bootcamp.airlinemanager.origin;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Origin {

	@Id
	private Integer idOrigin;
	private String location;
	private Double price_origin; // Adds to the price of the flight when used as origin
	private Double price_scale; // Adds to the price of the flight when used as scale (not used in endpoints)
	private Double price_destination; // Adds to the price of the flight when used as destination
	// scalePos possible values: A, B, C, D
	// Flights must go from A to D or from D to A in order
	// Possible flight scales: B->C, C->B->A and so on
	private Character scalePos;

	public Origin() {
	}

	public Origin(Integer idOrigin, String location, Double price_origin, Double price_scale, Double price_destination,
			Character scalePos) {
		super();
		this.idOrigin = idOrigin;
		this.location = location;
		this.price_origin = price_origin;
		this.price_scale = price_scale;
		this.price_destination = price_destination;
		this.scalePos = scalePos;
	}

	public Integer getIdOrigin() {
		return idOrigin;
	}

	public void setIdOrigin(Integer idOrigin) {
		this.idOrigin = idOrigin;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getPrice_origin() {
		return price_origin;
	}

	public void setPrice_origin(Double price_origin) {
		this.price_origin = price_origin;
	}

	public Double getPrice_scale() {
		return price_scale;
	}

	public void setPrice_scale(Double price_scale) {
		this.price_scale = price_scale;
	}

	public Double getPrice_destination() {
		return price_destination;
	}

	public void setPrice_destination(Double price_destination) {
		this.price_destination = price_destination;
	}

	public Character getScalePos() {
		return scalePos;
	}

	public void setScalePos(Character scalePos) {
		this.scalePos = scalePos;
	}

}