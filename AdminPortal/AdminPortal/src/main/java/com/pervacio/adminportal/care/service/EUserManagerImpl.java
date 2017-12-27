package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.care.dao.EUserDao;
import com.pervacio.adminportal.care.entities.EUser;


@Service
public class EUserManagerImpl implements EUserManager {

	@Autowired
	EUserDao dao;

		public List<EUser> getAll()  {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(EUser EUser) throws Exception {
		// TODO Auto-generated method stub
		dao.add(EUser);
	}

	public void remove(int id) throws Exception{
		// TODO Auto-generated method stub
//		dao.remove(id);
	}

	public void update(EUser EUser) throws Exception {
		// TODO Auto-generated method stub
		dao.update(EUser);
	};

	public Boolean getUserByUsernameAndPassword(String userid,String password) throws Exception{
		return dao.getUserByUsernameAndPassword(userid, password);

	}

	public EUser getUserByUsername(String userid) throws Exception{

		return dao.getUserByUsername(userid);
	}
}
