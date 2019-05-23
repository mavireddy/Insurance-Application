package com.ektha.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Driver {
	@Id
	@GeneratedValue
	private String driver_id;
	private String name;
	private String license;
	private int age;
	
	/*@OneToOne(mappedBy="driver")
	private Quote quote;

	
	
	public Quote getQuote() {
		return quote;
	}


	public void setQuote(Quote quote) {
		this.quote = quote;
	}*/


	@Override
	public String toString() {
		return "Driver [driver_id=" + driver_id + ", name=" + name + ", license=" + license + ", age=" + age + "]";
	}


	public String getLicense() {
		return license;
	}


	public void setLicense(String license) {
		this.license = license;
	}


	public String getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	

}
