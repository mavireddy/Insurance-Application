package com.ektha.insurance.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ektha.insurance.entity.Address;
import com.ektha.insurance.entity.Vehicle;


@Repository
public class VehicleDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Vehicle getVehicleById(String vehicleId) {
		return entityManager.find(Vehicle.class, vehicleId);
	
	}
	
	
/*	public List<Vehicle> getAllVehiclesAtAddress(String addressLine1) {

		List<Vehicle> vehicleList = new ArrayList<Vehicle>();

		String hql = "from Address as ads inner join ads.vehicles as vhl where address_line1=:addressLine1";
		Query query = entityManager.createQuery(hql);
		query.setParameter("addressLine1", addressLine1);
		//query.setParameter("addressLine2", addressLine2);

		List<?> resultList = query.getResultList();

		for (int i = 0; i < resultList.size(); i++) {

			Object[] row = (Object[]) resultList.get(i);
			//Address address = (Address) row[0];
			Vehicle vehicle = (Vehicle) row[1];
			vehicleList.add(vehicle);

			
			
		}

		return vehicleList;

	}*/
	
	public List<Vehicle> getAllVehiclesAtAddress(Address address) {

		List<Vehicle> vehicleList = new ArrayList<Vehicle>();

		String hql = "from Address as ads inner join ads.vehicles as vhl where address_line1=:addressLine1 and address_line2=:addressLine2 and city=:city and state=:state and zipcode=:zipcode ";
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
			Vehicle vehicle = (Vehicle) row[1];
			vehicleList.add(vehicle);

			
			
		}

		return vehicleList;

	}
	
	

}
