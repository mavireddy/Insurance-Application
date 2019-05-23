package com.ektha.insurance.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ektha.insurance.entity.Address;
import com.ektha.insurance.entity.Driver;
import com.ektha.insurance.entity.Vehicle;

@Repository
public class DriverDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Driver getDriverById(String driverId) {
		return entityManager.find(Driver.class, driverId);
	
	}

	public List<Driver> getAllDriversAtAddress(Address address) {

		List<Driver> driverList = new ArrayList<Driver>();

		String hql = "from Address as ads inner join ads.drivers as vhl where address_line1=:addressLine1 and address_line2=:addressLine2 and city=:city and state=:state and zipcode=:zipcode ";
		Query query = entityManager.createQuery(hql);
		query.setParameter("addressLine1", address.getAddress_line1());
		query.setParameter("addressLine2", address.getAddress_line2());
		query.setParameter("city", address.getCity());
		query.setParameter("state", address.getState());
		query.setParameter("zipcode", address.getZipcode());

		List<?> resultList = query.getResultList();

		for (int i = 0; i < resultList.size(); i++) {

			Object[] row = (Object[]) resultList.get(i);
			//Address address = (Address) row[0];
			Driver driver = (Driver) row[1];
			driverList.add(driver);

			
			
		}

		return driverList;

	}
	
	

}
