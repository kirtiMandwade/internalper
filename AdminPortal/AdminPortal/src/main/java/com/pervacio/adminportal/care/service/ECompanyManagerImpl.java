package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.care.dao.ECompanyDao;
import com.pervacio.adminportal.care.entities.ECompany;


@Service
public class ECompanyManagerImpl implements ECompanyManager {

	@Autowired
	ECompanyDao dao;

	public List<ECompany> getAll()  {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(ECompany eCompany) throws Exception {
		// TODO Auto-generated method stub
		dao.add(eCompany);
	}

	public void remove(ECompany eCompany) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(eCompany);
	}

	public void update(ECompany eCompany) throws Exception {
		// TODO Auto-generated method stub
		dao.update(eCompany);
	};
	public ArrayList<ECompany> getECompanyByCompanyName(String companyName) throws Exception{
		return dao.getECompanyByCompanyName(companyName);
	}
}
