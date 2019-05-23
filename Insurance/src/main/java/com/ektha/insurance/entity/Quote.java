package com.ektha.insurance.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="quote")
public class Quote{
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String quote_number;
	
	private String vehicle_id;
	
	private String driver_id;
	
	private float amount;
	
/*	@OneToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	@OneToOne
	@JoinColumn(name="driver_id")
	private Driver driver;*/
	
	public Quote()
	{}
	
	

	public Quote(String quote_number, String vehicle_id, String driver_id, float amount) {
		super();
		this.quote_number = quote_number;
		this.vehicle_id = vehicle_id;
		this.driver_id = driver_id;
		this.amount = amount;
	}



	public String getQuote_number() {
		return quote_number;
	}

	public void setQuote_number(String quote_number) {
		this.quote_number = quote_number;
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}



	@Override
	public String toString() {
		return "Quote [quote_number=" + quote_number + ", vehicle_id=" + vehicle_id + ", driver_id=" + driver_id
				+ ", amount=" + amount + "]";
	}

	
	
	




	
	


	
	

}
