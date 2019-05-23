package com.ektha.insurance.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long address_id;
	private String address_line1;
	private String address_line2;
	private String city;
	private String state;
	private Integer zipcode;
	@OneToMany//(mappedBy="address")
	@JoinColumn(name="address_id")
	private List<Vehicle> vehicles= new ArrayList<Vehicle>();
	
	@OneToMany//(mappedBy="address")
	@JoinColumn(name="address_id")
	private List<Driver> drivers= new ArrayList<Driver>();
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Address()
	{
		
	}
	
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address_line1=" + address_line1 + ", address_line2="
				+ address_line2 + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}
	public Address(Long address_id, String address_line1, String address_line2, String city, String state,
			int zipcode) {
		super();
		this.address_id = address_id;
		this.address_line1 = address_line1;
		this.address_line2 = address_line2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public Address(String address_line1, String address_line2, String city, String state,
			int zipcode) {
		super();
		this.address_line1 = address_line1;
		this.address_line2 = address_line2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	
	public Long getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}
	public String getAddress_line1() {
		return address_line1;
	}
	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}
	public String getAddress_line2() {
		return address_line2;
	}
	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	

}
