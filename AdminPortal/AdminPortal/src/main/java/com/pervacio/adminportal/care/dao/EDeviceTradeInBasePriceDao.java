package com.pervacio.adminportal.care.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.care.entities.EDeviceTradeInBasePrice;
import com.pervacio.adminportal.care.repository.EDeviceTradeInBasePriceRepository;

@Repository
@Transactional
public class EDeviceTradeInBasePriceDao
{
	@Autowired
	private EDeviceTradeInBasePriceRepository eDeviceTradeInBasePriceRepository;


	public List<EDeviceTradeInBasePrice> getAll() {
		// TODO Auto-generated method stub
		return eDeviceTradeInBasePriceRepository.findAll();
	}


	public void add(EDeviceTradeInBasePrice eDeviceTradeInBasePrice) throws Exception {
		// TODO Auto-generated method stub
		eDeviceTradeInBasePriceRepository.saveAndFlush(eDeviceTradeInBasePrice);
	}


	public void remove(EDeviceTradeInBasePrice eDeviceTradeInBasePrice) throws Exception {
		// TODO Auto-generated method stub
		eDeviceTradeInBasePriceRepository.delete(eDeviceTradeInBasePrice);
	}


	public void update(EDeviceTradeInBasePrice eDeviceTradeInBasePrice) throws Exception {
		// TODO Auto-generated method stub
		eDeviceTradeInBasePriceRepository.saveAndFlush(eDeviceTradeInBasePrice);
	}


	public ArrayList<EDeviceTradeInBasePrice> getEDeviceTradeInBasePriceByCompanyName(String companyName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	/*@PersistenceContext
	private EntityManager manager;

	public List<EDeviceTradeInBasePrice> getAll() {
		List<EDeviceTradeInBasePrice> EDeviceTradeInBasePriceEntities = manager.createQuery("Select a From EDeviceTradeInBasePrice a", EDeviceTradeInBasePrice.class).getResultList();
		return EDeviceTradeInBasePriceEntities;
	}

	public void add(EDeviceTradeInBasePrice EDeviceTradeInBasePrice) throws  Exception {
		manager.persist(EDeviceTradeInBasePrice);

	}

	public void remove(EDeviceTradeInBasePrice feature) throws Exception {
		Query query = manager.createQuery(
				"delete From EDeviceTradeInBasePrice a where a.priceId =:priceId ");
		query.setParameter("priceId", feature.getPriceId());

		query.executeUpdate();


	}

	public void update(EDeviceTradeInBasePrice EDeviceTradeInBasePrice) throws Exception {
		manager.merge(EDeviceTradeInBasePrice);

	}

	public ArrayList<EDeviceTradeInBasePrice> getEDeviceTradeInBasePriceByModel(String CompanyName) throws Exception{
		Query query = manager.createQuery(
				"select a From EDeviceTradeInBasePrice a where a.CompanyName =:CompanyName");
		query.setParameter("CompanyName", CompanyName);
		ArrayList<EDeviceTradeInBasePrice> arrEDeviceTradeInBasePrices = null;
		if(query.getResultList().size()>0) {
			arrEDeviceTradeInBasePrices=(ArrayList<EDeviceTradeInBasePrice>) query.getResultList();
		}
		return arrEDeviceTradeInBasePrices;

	}
*/
}