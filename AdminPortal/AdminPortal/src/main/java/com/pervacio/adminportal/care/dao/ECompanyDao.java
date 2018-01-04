package com.pervacio.adminportal.care.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.care.entities.ECompany;
import com.pervacio.adminportal.care.repository.ECompanyRepository;

@Repository
@Transactional
public class ECompanyDao
{
	@Autowired
	private ECompanyRepository eCompanyRepository;


	public List<ECompany> getAll() {
		// TODO Auto-generated method stub
		return eCompanyRepository.findAll();
	}


	public void add(ECompany eCompany) throws Exception {
		// TODO Auto-generated method stub
		eCompanyRepository.saveAndFlush(eCompany);
	}


	public void remove(ECompany eCompany) throws Exception {
		// TODO Auto-generated method stub
		eCompanyRepository.delete(eCompany);
	}


	public void update(ECompany eCompany) throws Exception {
		// TODO Auto-generated method stub
		eCompanyRepository.saveAndFlush(eCompany);
	}


	public ArrayList<ECompany> getECompanyByCompanyName(String companyName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}