package com.pervacio.adminportal.care.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.care.entities.EUser;
import com.pervacio.adminportal.care.repository.EUserRepository;

@Repository
@Transactional
public class EUserDao
{
	@Autowired
	private EUserRepository eUserRepository;


	public List<EUser> getAll() {
		// TODO Auto-generated method stub
		return eUserRepository.findAll();
	}


	public void add(EUser eUser) throws Exception {
		// TODO Auto-generated method stub
		eUserRepository.saveAndFlush(eUser);
	}


	public void removeEUserEntity(EUser eUser) throws Exception {
		// TODO Auto-generated method stub
		eUserRepository.delete(eUser);
	}


	public void update(EUser eUser) throws Exception {
		// TODO Auto-generated method stub
		eUserRepository.saveAndFlush(eUser);
	}


	public Boolean getUserByUsernameAndPassword(String userId, String password) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<EUser> list = eUserRepository.findUserByUserIdAndPassword(userId, password);
		long count = 1;/*eUserRepository.countByUserIdAndPassword(userId, password);*/
		/*if(count > 0)
		{
			return true;
		}
		return false;*/
		if(list.size() > 0) {
			return true;
		}
		return false;
	}



	public EUser getUserByUsername(String userId) throws Exception {
		// TODO Auto-generated method stub
		return eUserRepository.findByUserId(userId);
	}

	/*@PersistenceContext
	private EntityManager manager;

	public List<EUser> getAll() {
		List<EUser> EUserEntities = manager.createQuery("Select a From EUser a", EUser.class).getResultList();
		return EUserEntities;
	}

	public void add(EUser EUser) throws  Exception {
		manager.persist(EUser);

	}

	public void removeEUserEntity(int id) throws Exception {
		EUser d= manager.find(EUser.class, id);
	         manager.remove(d);

	}

	public void updateEUserEntity(EUser EUser) throws Exception {
		manager.merge(EUser);

	}

	public Boolean getUserByUsernameAndPassword(String userid,String password) throws Exception{
		Query query = manager.createNativeQuery(
				"Select * from euser where userid=? and password=SHA2(?,256)");
		query.setParameter(1, userid);
		query.setParameter(2,password);

		EUser euser = null;
		if(query.getResultList().size()>0) {
			return true;
		}
		return false;

	}


	public EUser getUserByUsername(String userId) throws Exception{
		Query query = manager.createQuery(
				"select a From EUser a where a.userId =:userId");
		query.setParameter("userId", userId);

		EUser euser = null;
		if(query.getResultList().size()>0) {
			euser= (EUser) query.getSingleResult();
		}
		return euser;

	}
*/
}