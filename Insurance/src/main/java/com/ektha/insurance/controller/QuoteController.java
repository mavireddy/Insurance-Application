/*package com.ektha.insurance.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ektha.insurance.dao.VehicleDao;
import com.ektha.insurance.entity.Address;
import com.ektha.insurance.entity.Driver;
import com.ektha.insurance.service.QuoteService;

@RestController
@RequestMapping("insurance")
public class QuoteController {
	
	@Autowired
	private QuoteService quoteservice;
	
	@GetMapping(value="/quote")
	public ModelAndView getQuote(HttpServletRequest request, HttpServletResponse response) 
	{
			
		int ticket=Integer.parseInt(request.getParameter("ticket"));
		int year=Integer.parseInt(request.getParameter("year"));
		int age=Integer.parseInt(request.getParameter("age"));
		
		float quote_amount = quoteservice.calculateQuote(year, ticket, age);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("quote");
		model.addObject("Quote", quote_amount);
		
		return model;
		
	}

}
*/