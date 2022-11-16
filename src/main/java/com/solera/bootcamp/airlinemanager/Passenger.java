package com.solera.bootcamp.airlinemanager;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Passenger {

	@Id
	private String idDocument;
	private String name;
	private String surname;
	private String nationality;
	private int age;

	public Passenger() {
	}

	public Passenger(String idDocument, String name, String surname, String nationality, int age) {
		super();
		this.idDocument = idDocument;
		this.name = name;
		this.surname = surname;
		this.nationality = nationality;
		this.age = age;
	}

	public String getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(String idDocument) {
		this.idDocument = idDocument;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
