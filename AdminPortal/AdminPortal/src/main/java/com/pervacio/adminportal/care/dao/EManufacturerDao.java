package com.pervacio.adminportal.care.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.care.entities.EManufacturer;
import com.pervacio.adminportal.care.repository.EManufacturerRepository;

@Repository
@Transactional
public class EManufacturerDao
{
	@Autowired
	private EManufacturerRepository eManufacturerRepository;


	public List<EManufacturer> getAll() {
		// TODO Auto-generated method stub
		return eManufacturerRepository.findAll();
	}


	public void add(EManufacturer eManufacturer) throws Exception {
		// TODO Auto-generated method stub
		eManufacturerRepository.saveAndFlush(eManufacturer);
	}


	public void remove(EManufacturer eManufacturer) throws Exception {
		// TODO Auto-generated method stub
		eManufacturerRepository.delete(eManufacturer);
	}


	public void update(EManufacturer eManufacturer) throws Exception {
		// TODO Auto-generated method stub
		eManufacturerRepository.saveAndFlush(eManufacturer);

	}


	public ArrayList<EManufacturer> getEManufacturerByManufacturerName(String manufacturerName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*@PersistenceContext
	private EntityManager manager;

	public List<EManufacturer> getAll() {
		List<EManufacturer> EManufacturerEntities = manager.createQuery("Select a From EManufacturer a", EManufacturer.class).getResultList();
		return EManufacturerEntities;
	}

	public void add(EManufacturer EManufacturer) throws  Exception {
		manager.persist(EManufacturer);

	}

	public void remove(EManufacturer feature) throws Exception {
		Query query = manager.createQuery(
				"delete From EManufacturer a where a.manufacturerId =:manufacturerId ");
		query.setParameter("manufacturerId", feature.getManufacturerId());

		query.executeUpdate();


	}

	public void update(EManufacturer EManufacturer) throws Exception {
		manager.merge(EManufacturer);

	}

	public ArrayList<EManufacturer> getEManufacturerByModel(String ManufacturerName) throws Exception{
		Query query = manager.createQuery(
				"select a From EManufacturer a where a.ManufacturerName =:ManufacturerName");
		query.setParameter("ManufacturerName", ManufacturerName);
		ArrayList<EManufacturer> arrEManufacturers = null;
		if(query.getResultList().size()>0) {
			arrEManufacturers=(ArrayList<EManufacturer>) query.getResultList();
		}
		return arrEManufacturers;

	}
*/
}