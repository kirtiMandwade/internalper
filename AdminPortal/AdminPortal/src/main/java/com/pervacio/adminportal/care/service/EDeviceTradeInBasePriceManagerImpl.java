package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.care.dao.EDeviceTradeInBasePriceDao;
import com.pervacio.adminportal.care.entities.EDeviceTradeInBasePrice;


@Service
public class EDeviceTradeInBasePriceManagerImpl implements EDeviceTradeInBasePriceManager {

	@Autowired
	EDeviceTradeInBasePriceDao dao;

		public List<EDeviceTradeInBasePrice> getAll()  {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(EDeviceTradeInBasePrice eDeviceTradeInBasePrice) throws Exception {
		// TODO Auto-generated method stub
		dao.add(eDeviceTradeInBasePrice);
	}

	public void remove(EDeviceTradeInBasePrice eDeviceTradeInBasePrice) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(eDeviceTradeInBasePrice);
	}

	public void update(EDeviceTradeInBasePrice eDeviceTradeInBasePrice) throws Exception {
		// TODO Auto-generated method stub
		dao.update(eDeviceTradeInBasePrice);
	};
	public ArrayList<EDeviceTradeInBasePrice> getEDeviceTradeInBasePriceByCompanyName(String companyName) throws Exception{
		return dao.getEDeviceTradeInBasePriceByCompanyName(companyName);
	}
}
