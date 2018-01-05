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


	public void remove(EUser eUser) throws Exception {
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
}