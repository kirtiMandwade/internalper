package com.pervacio.adminportal.warehouse.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.warehouse.entities.WorkStationFeature;
import com.pervacio.adminportal.warehouse.model.WorkStationFeatureBean;
import com.pervacio.adminportal.warehouse.repository.WorkStationFeatureRepository;

@Repository
@Transactional
public class WorkstationFeatureDao
{
	@Autowired
	private WorkStationFeatureRepository workStationFeatureRepository;


	public List<WorkStationFeature> getAll() {
		// TODO Auto-generated method stub
		return workStationFeatureRepository.findAll();
	}


	public void add(WorkStationFeature workStationFeature) throws Exception {
		// TODO Auto-generated method stub
		workStationFeatureRepository.saveAndFlush(workStationFeature);
	}


	public void addWorkStationFeatureList(ArrayList<WorkStationFeature> workStationFeatureList) throws Exception {
		// TODO Auto-generated method stub
//		workStationFeatureRepository.saveAll(WorkStationFeatureList);
	}


	public void remove(WorkStationFeature workStationFeature) throws Exception {
		// TODO Auto-generated method stub
		workStationFeatureRepository.delete(workStationFeature);
	}


	public void update(WorkStationFeature workStationFeature) throws Exception {
		// TODO Auto-generated method stub
		workStationFeatureRepository.saveAndFlush(workStationFeature);
	}


	public ArrayList<WorkStationFeature> getWorkStationFeatureByFeatureValue(String featureValue) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}