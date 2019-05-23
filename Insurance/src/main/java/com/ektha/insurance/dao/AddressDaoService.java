package com.ektha.insurance.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ektha.insurance.entity.Address;


@Repository
@Transactional
public class AddressDaoService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(Address address)
	{
		entityManager.persist(address);
		return address.getAddress_id();
	}
	
	public Address getAddressById(long addressId) {
		return entityManager.find(Address.class, addressId);
	
	}

}
