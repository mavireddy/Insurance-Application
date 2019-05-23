package com.ektha.insurance.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ektha.insurance.dao.VehicleDao;
import com.ektha.insurance.entity.Address;
import com.ektha.insurance.entity.Vehicle;

@RestController
@RequestMapping("insurance")
public class vehicleController {
	
	@Autowired
	private VehicleDao vehicledao;
	
	
/*	@GetMapping("vehicles/{id}")
	public ResponseEntity<List<Vehicle>> getVehiclesByQuery(@PathVariable("id") String id) {
		List<Vehicle> vehicles = vehicledao.getAllVehiclesAtAddress(id);
		return new ResponseEntity <List<Vehicle>>( vehicles, HttpStatus.OK);
	}*/
	/*
	@GetMapping("vehicles/{id}")
	public ResponseEntity<List<Vehicle>> getVehiclesByQuery(@PathVariable("id") String id) {
		List<Vehicle> vehicles = vehicledao.getAllVehiclesAtAddress(id);
		return new ResponseEntity <List<Vehicle>>( vehicles, HttpStatus.OK);
	}*/
	

	@GetMapping("vehicles/{address_line1}/{address_line2}/{city}/{state}/{zipcode}")
	//@GetMapping("/vehicles")
	public ResponseEntity<List<Vehicle>> getVehiclesByQuery(@PathVariable("address_line1") String address_line1, @PathVariable("address_line2") String address_line2, @PathVariable("city") String city, @PathVariable("state") String state, @PathVariable("zipcode") int zipcode) 
	{
		/*String address_line1= request.getParameter("address_line1");
		
		//System.out.println(address_line1);
		String address_line2= request.getParameter("address_line2");
		String city= request.getParameter("city");
		String state= request.getParameter("state");
		int zipcode= Integer.parseInt(request.getParameter("zipcode"));*/
		
		/*String address_line1= "3227 Bishop Street";
		String address_line2= "Unit 2";
		String city= "Cincinnati";
		String state= "Ohio";
		int zipcode= 45220;*/
		
		

		List<Vehicle> vehicles = vehicledao.getAllVehiclesAtAddress(new Address(address_line1, address_line2, city, state, zipcode));
		return new ResponseEntity <List<Vehicle>>( vehicles, HttpStatus.OK);
	}
	
	

}
