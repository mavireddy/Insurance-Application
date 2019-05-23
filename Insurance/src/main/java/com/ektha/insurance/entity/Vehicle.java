package com.ektha.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue
	private String vehicle_id;
	private String vin_number;
	private String model;
	private int year;
	
	/*@OneToOne(mappedBy="vehicle")
	private Quote quote;

	*/
	
	@Override
	public String toString() {
		return "Vehicle [vehicle_id=" + vehicle_id + ", vin_number=" + vin_number + ", model=" + model + ", year="
				+ year + "]";
	}
	/*public Quote getQuote() {
		return quote;
	}
	public void setQuote(Quote quote) {
		this.quote = quote;
	}*/
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getVin_number() {
		return vin_number;
	}
	public void setVin_number(String vin_number) {
		this.vin_number = vin_number;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	

}

