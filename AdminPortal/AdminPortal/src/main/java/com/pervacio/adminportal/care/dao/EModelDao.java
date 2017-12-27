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
import com.pervacio.adminportal.repository.care.EModelRepository;

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

	/*@PersistenceContext
	private EntityManager manager;

	public List<EModel> getAll() {
		List<EModel> EModelEntities = manager.createQuery("Select a From EModel a", EModel.class).getResultList();
		return EModelEntities;
	}

	public void add(EModel EModel) throws  Exception {
		manager.persist(EModel);

	}

	public void remove(EModel feature) throws Exception {
		Query query = manager.createQuery(
				"delete From EModel a where a.deviceModelId =:deviceModelId ");
		query.setParameter("deviceModelId", feature.getDeviceModelId());

		query.executeUpdate();


	}

	public void update(EModel EModel) throws Exception {
		manager.merge(EModel);

	}

	public ArrayList<EModel> getEModelByModel(String ModelNumber) throws Exception{
		Query query = manager.createQuery(
				"select a From EModel a where a.ModelNumber =:ModelNumber");
		query.setParameter("ModelNumber", ModelNumber);
		ArrayList<EModel> arrEModels = null;
		if(query.getResultList().size()>0) {
			arrEModels=(ArrayList<EModel>) query.getResultList();
		}
		return arrEModels;

	}
*/
}