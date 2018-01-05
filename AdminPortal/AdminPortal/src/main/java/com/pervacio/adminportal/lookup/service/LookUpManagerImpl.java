package com.pervacio.adminportal.lookup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pervacio.adminportal.lookup.dao.LookUpDao;
import com.pervacio.adminportal.lookup.entities.LookUp;
import com.pervacio.adminportal.lookup.entities.LookUpKey;

public class LookUpManagerImpl implements LookUpManager{
	
	@Autowired
	LookUpDao dao;
	

	@Override
	public List<LookUp> findByLookUpKey(LookUpKey lookUpKey) throws Exception {
		// TODO Auto-generated method stub
		return  dao.findByLookUpKey(lookUpKey);
	}

}
