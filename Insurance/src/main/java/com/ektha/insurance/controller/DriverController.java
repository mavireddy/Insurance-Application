package com.ektha.insurance.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ektha.insurance.dao.AddressDaoService;
import com.ektha.insurance.dao.DriverDao;
import com.ektha.insurance.dao.QuoteDao;
import com.ektha.insurance.dao.VehicleDao;
import com.ektha.insurance.entity.Address;
import com.ektha.insurance.entity.Driver;
import com.ektha.insurance.entity.Quote;
import com.ektha.insurance.entity.Vehicle;
import com.ektha.insurance.service.QuoteGeneratorService;
import com.ektha.insurance.service.QuoteService;

@RestController
@RequestMapping("insurance")
@SessionAttributes({"Vehicle","Driver","Quote","License"})

public class DriverController {
	
	@Autowired
	private DriverDao driverdao;
	
	@Autowired
	private AddressDaoService addressdao;
	
	
	@Autowired
	private VehicleDao vehicleDao;
	
	@Autowired
	private QuoteService quoteservice;
	
	@Autowired
	private QuoteGeneratorService quotegenservice;
	
	@Autowired
	private QuoteDao quotedao;


	@GetMapping("drivers/{address_line1}/{address_line2}/{city}/{state}/{zipcode}")
	public ResponseEntity<List<Driver>> getDriversByQuery(@PathVariable("address_line1") String address_line1, @PathVariable("address_line2") String address_line2, @PathVariable("city") String city, @PathVariable("state") String state, @PathVariable("zipcode") int zipcode) 
	{


		List<Driver> drivers = driverdao.getAllDriversAtAddress(new Address(address_line1, address_line2, city, state, zipcode));
		return new ResponseEntity <List<Driver>>( drivers, HttpStatus.OK);
	}
	
	//@SuppressWarnings("unused")
	@GetMapping(value="/driverdetails")
	public ModelAndView getDriverDetails(HttpServletRequest request, HttpServletResponse response)
	
	{
		
		String vehicle_id= request.getParameter("vehicle");
		String driver_id = request.getParameter("driver");
	
		Driver driverObj = driverdao.getDriverById(driver_id);
		String license= driverObj.getLicense();
		Vehicle vehicleObj = vehicleDao.getVehicleById(vehicle_id);
		
		List<Quote> quotelist=quotedao.getQuoteByQuery(driver_id, vehicle_id);
		//System.out.println(quote.getVehicle_id() + quote.getDriver_id() + quote.getQuote_number());
		
		if(!quotelist.isEmpty())
		{
			
			ModelAndView model1 = new ModelAndView();
			model1.setViewName("home");
			model1.addObject("Warning", "This combination already has a quote calculated. Please enter your quote ID above");
			return model1;
		
		}
		else
		{
			String driverName = driverObj.getName();
			ModelAndView model = new ModelAndView();
			model.setViewName("driverdetails");
			model.addObject("Vehicle", vehicleObj);
			model.addObject("Driver", driverObj);
			model.addObject("Name", driverName);
			model.addObject("License", license);
			return model;
		}
	}
	
	@GetMapping(value="/quote")
	public ModelAndView getQuote(HttpServletRequest request, HttpServletResponse response , @ModelAttribute("Vehicle") Vehicle vehicleObj, @ModelAttribute("Driver") Driver driverObj, @ModelAttribute("License") String license) 
	{

		int year= vehicleObj.getYear();
		int age= driverObj.getAge();
		String vehicle_name = vehicleObj.getModel();
		String driver_name = driverObj.getName();
		String driver_id = driverObj.getDriver_id();
		String vin_number = vehicleObj.getVin_number();
		
		
		String quote_num=quotegenservice.generateQuote(driver_name, vehicle_name,driver_id, vin_number);
		
		String driver_license= request.getParameter("license");
		System.out.println(license);
		int ticket=Integer.parseInt(request.getParameter("ticket"));
		
		if(driver_license.equals(license)) {
		float quote_amount = quoteservice.calculateQuote(year, ticket, age);
		
		quotedao.insert(new Quote(quote_num,vehicleObj.getVehicle_id(),driverObj.getDriver_id(),quote_amount));	
		
		ModelAndView model = new ModelAndView();
		model.setViewName("quote");
		model.addObject("QuoteAmount", quote_amount);
		model.addObject("Quote",quote_num);
		
		return model;
		}
		else
		{
			ModelAndView model1 = new ModelAndView();
			model1.setViewName("driverdetails");
			model1.addObject("Error", "'Sorry, this license is not valid'");

			return model1;
		}
		
	}
	
	
	@GetMapping(value="/quotedetails")
	public ModelAndView getQuotedetails(HttpServletRequest request, HttpServletResponse response) 
	{
		
		String quoteId= request.getParameter("quote_num");
		
	
		Quote quote=quotedao.getQuoteById(quoteId);
		
		if (quote!= null)
		{
			float amount=quote.getAmount();
			String driverId=quote.getDriver_id();
			String vehicleId=quote.getVehicle_id();
			
			Driver driver= driverdao.getDriverById(driverId);
			Vehicle vehicle = vehicleDao.getVehicleById(vehicleId);
			
			ModelAndView model = new ModelAndView();
			model.setViewName("quotedetails");
			model.addObject("Driver",driver);
			model.addObject("Vehicle",vehicle);
			model.addObject("Amount", amount);
			
			return model;
		}
		else {
			ModelAndView model1 = new ModelAndView();
			model1.setViewName("home");
			model1.addObject("Error", "'Sorry, this quote is not valid'");
			return model1;

		}

		
		
	}
	


}
