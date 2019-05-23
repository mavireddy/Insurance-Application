package com.ektha.insurance.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ektha.insurance.entity.Address;
import com.ektha.insurance.repository.AddressRepository;

@Repository
public class AddressDao {

	
	@Autowired
	public AddressRepository addressrepository;
	
	public Address save(Address address)
	{
		return addressrepository.save(address);
		
	}
	
	public Optional<Address> findOne(Long addressid)
	{
		return addressrepository.findById(addressid);
		
	}
	
	public List<Address> findAll()
	{
		return addressrepository.findAll();
	}
	
	
	
}
