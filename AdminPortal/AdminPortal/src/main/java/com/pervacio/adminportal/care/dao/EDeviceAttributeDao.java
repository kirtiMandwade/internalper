package com.pervacio.adminportal.care.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.care.entities.EDeviceAttribute;
import com.pervacio.adminportal.repository.care.EDeviceAttributeRepository;

@Repository
@Transactional
public class EDeviceAttributeDao
{
	@Autowired
	private EDeviceAttributeRepository eDeviceAttributeRepository;


	public List<EDeviceAttribute> getAll() {
		// TODO Auto-generated method stub
		return eDeviceAttributeRepository.findAll();
	}


	public void add(EDeviceAttribute eDeviceAttribute) throws Exception {
		// TODO Auto-generated method stub
		eDeviceAttributeRepository.saveAndFlush(eDeviceAttribute);
	}


	public void remove(EDeviceAttribute eDeviceAttribute) throws Exception {
		// TODO Auto-generated method stub
		eDeviceAttributeRepository.delete(eDeviceAttribute);
	}


	public void update(EDeviceAttribute eDeviceAttribute) throws Exception {
		// TODO Auto-generated method stub
		eDeviceAttributeRepository.saveAndFlush(eDeviceAttribute);

	}


	public ArrayList<EDeviceAttribute> getEDeviceAttributeByAttributeName(String attributeName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	/*@PersistenceContext
	private EntityManager manager;

	public List<EDeviceAttribute> getAll() {
		List<EDeviceAttribute> EDeviceAttributeEntities = manager.createQuery("Select a From EDeviceAttribute a", EDeviceAttribute.class).getResultList();
		return EDeviceAttributeEntities;
	}

	public void add(EDeviceAttribute EDeviceAttribute) throws  Exception {
		manager.persist(EDeviceAttribute);

	}

	public void remove(EDeviceAttribute feature) throws Exception {
		Query query = manager.createQuery(
				"delete From EDeviceAttribute a where a.attributeId =:attributeId ");
		query.setParameter("attributeId", feature.getAttributeId());

		query.executeUpdate();


	}

	public void update(EDeviceAttribute EDeviceAttribute) throws Exception {
		manager.merge(EDeviceAttribute);

	}

	public ArrayList<EDeviceAttribute> getEDeviceAttributeByModel(String AttributeName) throws Exception{
		Query query = manager.createQuery(
				"select a From EDeviceAttribute a where a.AttributeName =:AttributeName");
		query.setParameter("AttributeName", AttributeName);
		ArrayList<EDeviceAttribute> arrEDeviceAttributes = null;
		if(query.getResultList().size()>0) {
			arrEDeviceAttributes=(ArrayList<EDeviceAttribute>) query.getResultList();
		}
		return arrEDeviceAttributes;

	}
*/
}