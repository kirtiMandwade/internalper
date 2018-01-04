package com.pervacio.adminportal.lookup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pervacio.adminportal.lookup.dao.LookUpDao;
import com.pervacio.adminportal.lookup.entities.LookUp;

public class LookUpManagerImpl implements LookUpManager{
	
	@Autowired
	LookUpDao dao;
	
	public List<LookUp> getLookUpByLookUpType(String lookUpType)throws Exception{
		return dao.getLookUpByLookUpType(lookUpType);
	}

}
