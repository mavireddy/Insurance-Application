package com.ektha.insurance.service;

import java.security.SecureRandom;

import org.springframework.stereotype.Controller;


@Controller
public class RandomGenerator {
	
	public int generateRandomNumber()
	{
		SecureRandom random = new SecureRandom();
		int num = random.nextInt(100000);
		
		return num;
		
	}

}
