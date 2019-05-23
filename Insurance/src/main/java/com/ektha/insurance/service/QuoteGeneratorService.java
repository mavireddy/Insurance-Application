package com.ektha.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteGeneratorService {
		
	@Autowired
	private RandomGenerator randomgenerator;
	
	
	
	public String generateQuote(String driver_name, String vehicle_name,String driver_id, String vin_number){
		
		int randomnumber= randomgenerator.generateRandomNumber();
		
		String quote_id = driver_name.substring(0,1) + vehicle_name.substring(0, 1)+ driver_id + vin_number.substring(0,1);
		
		return quote_id;
		
	}
}
