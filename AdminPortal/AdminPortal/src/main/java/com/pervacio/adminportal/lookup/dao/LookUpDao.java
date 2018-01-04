package com.pervacio.adminportal.lookup.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.lookup.entities.LookUp;
import com.pervacio.adminportal.lookup.repository.LookUpRepository;

@Repository
@Transactional
public class LookUpDao {
	
	@Autowired
	LookUpRepository lookUpRepository;
	
	public List<LookUp> getLookUpByLookUpType(String lookUpType)throws Exception{
		return lookUpRepository.findByLookUpType(lookUpType);
	}
}
