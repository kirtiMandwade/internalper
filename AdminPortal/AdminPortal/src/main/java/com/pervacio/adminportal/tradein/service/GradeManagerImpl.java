package com.pervacio.adminportal.tradein.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.tradein.dao.GradeDao;
import com.pervacio.adminportal.tradein.entities.Grade;


@Service
public class GradeManagerImpl implements GradeManager {

	@Autowired
	GradeDao dao;

		public List<Grade> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(Grade grade)  throws Exception {
		// TODO Auto-generated method stub
		dao.add(grade);
	}

	public void remove(Grade grade)  throws Exception{
		// TODO Auto-generated method stub
		dao.remove(grade);
	}

	public void update(Grade grade)  throws Exception{
		// TODO Auto-generated method stub
		dao.update(grade);
	};

}
