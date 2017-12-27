package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.care.dao.EDeviceAttributeDao;
import com.pervacio.adminportal.care.entities.EDeviceAttribute;


@Service
public class EDeviceAttributeManagerImpl implements EDeviceAttributeManager {

	@Autowired
	EDeviceAttributeDao dao;

		public List<EDeviceAttribute> getAll()  {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(EDeviceAttribute eDeviceAttribute) throws Exception {
		// TODO Auto-generated method stub
		dao.add(eDeviceAttribute);
	}

	public void remove(EDeviceAttribute eDeviceAttribute) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(eDeviceAttribute);
	}

	public void update(EDeviceAttribute eDeviceAttribute) throws Exception {
		// TODO Auto-generated method stub
		dao.update(eDeviceAttribute);
	};
	public ArrayList<EDeviceAttribute> getEDeviceAttributeByAttributeName(String attributeName) throws Exception{
		return dao.getEDeviceAttributeByAttributeName(attributeName);
	}
}
