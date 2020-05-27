package com.mycompany.myclient.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private Long id;

	private String description;
	private String street;
	private String number;
	private String floor;

	@ManyToOne
	private Client client;

	protected Address() {
	}

	public Address(String description, String street, String number, String floor) {
		this.description = description;
		this.street = street;
		this.number = number;
		this.floor = floor;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Address{" +
				"description='" + description + '\'' +
				", street='" + street + '\'' +
				", number='" + number + '\'' +
				", floor='" + floor + '\'' +
				'}';
	}
}