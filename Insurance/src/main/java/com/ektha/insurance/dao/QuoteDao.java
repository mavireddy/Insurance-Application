package com.ektha.insurance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ektha.insurance.entity.Address;
import com.ektha.insurance.entity.Quote;

@Repository
@Transactional
public class QuoteDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Quote quote)
	{
		entityManager.persist(quote);
		//return quote.getQuote_id();
	}
	
	public Quote getQuoteById(String quoteId) {
		return entityManager.find(Quote.class, quoteId);
	
	}
	
	public List<Quote> getQuoteByQuery(String driverid, String vehicleid)
	{
		String hql = "from Quote as q where driver_id=:driverid and vehicle_id=:vehicleid";
		Query query = entityManager.createQuery(hql);
		query.setParameter("driverid", driverid);
		query.setParameter("vehicleid", vehicleid);
		
		List<Quote> quote=(List<Quote>) query.getResultList();
		
		return quote;
	}

}
