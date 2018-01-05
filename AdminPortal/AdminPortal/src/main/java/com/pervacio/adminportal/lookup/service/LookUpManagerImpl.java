package com.pervacio.adminportal.lookup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.lookup.dao.LookUpDao;
import com.pervacio.adminportal.lookup.entities.LookUp;
import com.pervacio.adminportal.lookup.entities.LookUpKey;

@Service
public class LookUpManagerImpl implements LookUpManager{
	
	@Autowired
	LookUpDao dao;
	

	@Override
	public List<LookUp> findAllByLookUpKeyLookUpType(String lookUpType)throws Exception {
		// TODO Auto-generated method stub
		return  dao.findAllByLookUpKeyLookUpType(lookUpType);
	}

}
