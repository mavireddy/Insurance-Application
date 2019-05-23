package com.ektha.insurance.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ektha.insurance.dao.AddressDao;
import com.ektha.insurance.dao.AddressDaoService;
import com.ektha.insurance.entity.Address;

@RestController
@RequestMapping("/insurance")
public class AddressController {

	@Autowired
	AddressDao addressdao;
	@Autowired
	AddressDaoService addressdaoservice;

	@GetMapping("/home")
	public ModelAndView getHome() {
		ModelAndView model= new ModelAndView("home");
		return model;
	}

	@GetMapping("/address/entitymanager/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable("id") long id) {
		Address address = addressdaoservice.getAddressById(id);
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}

	@PostMapping("/address")
	public Address createAddress(@Valid @RequestBody Address address) {
		return addressdao.save(address);
	}

	@GetMapping("/address_all")
	public List<Address> getAllEmployees() {
		return addressdao.findAll();
	}

	@GetMapping("/address/{id}")
	public ResponseEntity<Optional<Address>> getEmployeeById(@PathVariable(value = "id") Long empid) {

		Optional<Address> address = addressdao.findOne(empid);

		if (address == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(address);

	}

}
