package com.pervacio.adminportal.warehouse.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.warehouse.entities.WSProfile;
import com.pervacio.adminportal.warehouse.repository.WSProfileRepository;

@Repository
@Transactional
public class WSProfileDao
{
	@Autowired
	private WSProfileRepository wSProfileRepository;


	public List<WSProfile> getAll() {
		// TODO Auto-generated method stub
		return wSProfileRepository.findAll();
	}


	public void add(WSProfile wsProfile) throws Exception {
		// TODO Auto-generated method stub
		wSProfileRepository.saveAndFlush(wsProfile);
	}


	public void remove(WSProfile wsProfile) throws Exception {
		// TODO Auto-generated method stub
		wSProfileRepository.delete(wsProfile);
	}


	public void update(WSProfile wsProfile) throws Exception {
		// TODO Auto-generated method stub
		wSProfileRepository.saveAndFlush(wsProfile);

	}


	public ArrayList<WSProfile> getWSProfileByprofile(String profileDesc) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<WSProfile> getWSProfileByProfileCd(String profileCd) throws Exception{
		return wSProfileRepository.findAllByWsProfileIdProfileCd(profileCd);
	}
}