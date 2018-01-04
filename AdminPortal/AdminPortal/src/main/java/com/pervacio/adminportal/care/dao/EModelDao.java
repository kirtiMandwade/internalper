package com.pervacio.adminportal.care.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.care.entities.EModel;
import com.pervacio.adminportal.care.repository.EModelRepository;

@Repository
@Transactional
public class EModelDao
{
	@Autowired
	private EModelRepository eModelRepository;


	public List<EModel> getAll() {
		// TODO Auto-generated method stub
		return eModelRepository.findAll();
	}


	public void add(EModel eModel) throws Exception {
		// TODO Auto-generated method stub
		eModelRepository.saveAndFlush(eModel);
	}


	public void remove(EModel eModel) throws Exception {
		// TODO Auto-generated method stub
		eModelRepository.delete(eModel);
	}


	public void update(EModel eModel) throws Exception {
		// TODO Auto-generated method stub
		eModelRepository.saveAndFlush(eModel);
	}


	public ArrayList<EModel> getEModelByModel(String model) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}