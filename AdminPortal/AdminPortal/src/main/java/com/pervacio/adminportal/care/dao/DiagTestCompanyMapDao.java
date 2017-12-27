package com.pervacio.adminportal.care.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.care.entities.DiagTestCompanyMap;
import com.pervacio.adminportal.repository.care.DiagTestCompanyMapRepository;

@Repository
@Transactional
public class DiagTestCompanyMapDao
{

	@Autowired
	private DiagTestCompanyMapRepository diagTestCompanyMapRepo;

	public List<DiagTestCompanyMap> getAll() {

		return diagTestCompanyMapRepo.findAll();

	}

	public void add(DiagTestCompanyMap diagTestCompanyMap) throws Exception {
		diagTestCompanyMapRepo.saveAndFlush(diagTestCompanyMap);

	}

	public void remove(DiagTestCompanyMap diagTestCompanyMap) throws Exception {
		diagTestCompanyMapRepo.delete(diagTestCompanyMap);

	}

	public void update(DiagTestCompanyMap diagTestCompanyMap) throws Exception {
		diagTestCompanyMapRepo.saveAndFlush(diagTestCompanyMap);

	}




}