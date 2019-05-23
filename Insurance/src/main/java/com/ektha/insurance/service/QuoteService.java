package com.ektha.insurance.service;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

	public static float quoteBasedOnYear(int year) {
		float baseprice = 100;

		if (year < 2000) {
			baseprice += 150;

		} else if (year >= 2000 && year < 2005) {
			baseprice += 100;

		} else if (year >= 2005 && year < 2015) {
			baseprice += 75;

		} else if (year >= 2015) {
			baseprice += 50;

		}
		
		return baseprice;
	}
	
	public static float quoteBasedOnTickets(int ticket) {
		float baseprice = 0;

		if (ticket == 0) {
			baseprice = baseprice;

		} else if (ticket==1) {
			baseprice += 50;

		} else if (ticket==2) {
			baseprice += 75;

		} else if (ticket>=3) {
			baseprice += 100;

		}
		
		return baseprice;
	}
	
	public static float quoteBasedOnAge(int age) {
		float baseprice = 0;

		if (age>18 && age<25) {
			baseprice += 30;

		} else if (age>=25 && age<40) {
			baseprice += 50;

		} else if (age>=40) {
			baseprice += 75;

		} 

		return baseprice;
	}

	public float calculateQuote(int year, int ticket, int age) {
		float quote_amount = 0;
		
		float amount_year = quoteBasedOnYear(year);
		float amount_ticket = quoteBasedOnTickets(ticket);
		float amount_age= quoteBasedOnAge(age);
		
		quote_amount= amount_year+amount_ticket+amount_age;
		
		return quote_amount;
		

	}

}
