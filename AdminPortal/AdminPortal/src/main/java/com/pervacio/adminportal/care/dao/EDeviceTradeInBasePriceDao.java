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


}