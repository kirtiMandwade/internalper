package com.pervacio.adminportal.care.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.care.entities.DiagTest;
import com.pervacio.adminportal.care.repository.DiagTestRepository;
import com.pervacio.adminportal.care.entities.DiagTest;

@Repository
@Transactional
public class DiagTestDao
{

	@Autowired
	private DiagTestRepository diagTestRepository;
	public List<DiagTest> getAll() {

		return diagTestRepository.findAll();

	}

	public void add(DiagTest diagTest) throws Exception {
		diagTestRepository.saveAndFlush(diagTest);

	}

	public void remove(DiagTest diagTest) throws Exception {
		diagTestRepository.delete(diagTest);

	}

	public void update(DiagTest diagTest) throws Exception {
		diagTestRepository.saveAndFlush(diagTest);

	}


	public ArrayList<DiagTest> findByTestCd(String testCd) throws Exception {
	return	diagTestRepository.findByTestCd(testCd);

	}

}