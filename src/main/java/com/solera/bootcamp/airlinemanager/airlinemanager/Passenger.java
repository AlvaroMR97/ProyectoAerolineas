package com.solera.bootcamp.airlinemanager.airlinemanager;

import org.springframework.stereotype.Component;

@Component
public class Passenger {
	private String name;
	private String surname;
	private String nationality;
	private String idDocument;
	private int age;

	public Passenger(String name, String surname, String nationality, String idDocument, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.nationality = nationality;
		this.idDocument = idDocument;
		this.age = age;
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

	public String getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(String idDocument) {
		this.idDocument = idDocument;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
