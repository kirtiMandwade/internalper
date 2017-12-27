package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.care.dao.EManufacturerDao;
import com.pervacio.adminportal.care.entities.EManufacturer;


@Service
public class EManufacturerManagerImpl implements EManufacturerManager {

	@Autowired
	EManufacturerDao dao;

		public List<EManufacturer> getAll()  {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(EManufacturer eManufacturer) throws Exception {
		// TODO Auto-generated method stub
		dao.add(eManufacturer);
	}

	public void remove(EManufacturer eManufacturer) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(eManufacturer);
	}

	public void update(EManufacturer eManufacturer) throws Exception {
		// TODO Auto-generated method stub
		dao.update(eManufacturer);
	};
	public ArrayList<EManufacturer> getEManufacturerByManufacturerName(String manufactureName) throws Exception{
		return dao.getEManufacturerByManufacturerName(manufactureName);
	}
}
