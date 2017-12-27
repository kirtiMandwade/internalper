package com.pervacio.adminportal.warehouse.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.repository.warehouse.ProfileFeatureRepository;
import com.pervacio.adminportal.warehouse.entities.ProfileFeature;

@Repository
@Transactional
public class ProfileFeatureDao
{
	@Autowired
	private ProfileFeatureRepository profileFeatureRepository;


	public List<ProfileFeature> getAll() {
		// TODO Auto-generated method stub
		return profileFeatureRepository.findAll();
	}


	public void add(ProfileFeature profileFeature) throws Exception {
		// TODO Auto-generated method stub
		profileFeatureRepository.saveAndFlush(profileFeature);
	}


	public void remove(ProfileFeature profileFeature) throws Exception {
		// TODO Auto-generated method stub
		profileFeatureRepository.delete(profileFeature);
	}


	public void update(ProfileFeature profileFeature) throws Exception {
		// TODO Auto-generated method stub
		profileFeatureRepository.saveAndFlush(profileFeature);
	}


	public ArrayList<ProfileFeature> findByFeatureValue(String featureValue) throws Exception {
		// TODO Auto-generated method stub
		return profileFeatureRepository.findByFeatureValue(featureValue);
	}

}