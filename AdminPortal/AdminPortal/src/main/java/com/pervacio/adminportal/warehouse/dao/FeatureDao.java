package com.pervacio.adminportal.warehouse.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.warehouse.entities.Feature;
import com.pervacio.adminportal.warehouse.repository.FeatureRepository;

@Repository
@Transactional
public class FeatureDao
{
	@Autowired
	private FeatureRepository featureRepository;


	public List<Feature> getAll() {
		// TODO Auto-generated method stub
		return featureRepository.findAll();
	}


	public void add(Feature feature) throws Exception {
		// TODO Auto-generated method stub
		featureRepository.saveAndFlush(feature);
	}


	public void remove(Feature feature) throws Exception {
		// TODO Auto-generated method stub
		featureRepository.delete(feature);
	}


	public void update(Feature feature) throws Exception {
		// TODO Auto-generated method stub
		featureRepository.saveAndFlush(feature);
	}
	
	public ArrayList<Feature> getFeatureByFeatureCd(String featureCd) throws Exception{
		return featureRepository.findByFeatureCd(featureCd);
	}

}