package com.subbu.microservices.currencyserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Currencies {
	@Id
	@GeneratedValue
	private Integer id;
	private String currencyCode;
	private String country;
	private String description;
	
	public Currencies() {
		super();
	}

	public Currencies(String currencyCode, String country, String description) {
		super();
		this.currencyCode = currencyCode;
		this.country = country;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public String getCountry() {
		return country;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Currencies [id=" + id + ", currencyCode=" + currencyCode + ", country=" + country + ", description="
				+ description + "]";
	}
	
}
