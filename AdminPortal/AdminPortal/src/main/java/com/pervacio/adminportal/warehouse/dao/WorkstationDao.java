package com.pervacio.adminportal.warehouse.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.repository.warehouse.WorkStationRepository;
import com.pervacio.adminportal.warehouse.entities.WorkStation;

@Repository
@Transactional
public class WorkstationDao
{
	@Autowired
	private WorkStationRepository workStationRepository;


	public List<WorkStation> getAll() {
		// TODO Auto-generated method stub
		return workStationRepository.findAll();
	}


	public WorkStation add(WorkStation workStation) throws Exception {
		return workStation=	workStationRepository.saveAndFlush(workStation);
	}


	public void remove(WorkStation workStation) throws Exception {
		// TODO Auto-generated method stub
		workStationRepository.delete(workStation);
	}


	public void update(WorkStation workStation) throws Exception {
		// TODO Auto-generated method stub
		workStationRepository.saveAndFlush(workStation);
	}


	public ArrayList<WorkStation> getWorkStationByWorkStationId(int workStationId) throws Exception {
		// TODO Auto-generated method stub
		return workStationRepository.findByWorkStationId(workStationId);
	}

}