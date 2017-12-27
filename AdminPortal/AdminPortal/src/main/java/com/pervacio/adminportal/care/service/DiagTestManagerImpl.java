package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.care.dao.DiagTestDao;
import com.pervacio.adminportal.care.entities.DiagTest;


@Service
public class DiagTestManagerImpl implements DiagTestManager  {

	@Autowired
	DiagTestDao dao;


	public List<DiagTest> getAll() {

		return dao.getAll();

	}

	public void add(DiagTest diagTest) throws Exception {
		dao.add(diagTest);

	}

	public void remove(DiagTest diagTest) throws Exception {
		dao.remove(diagTest);

	}

	public void update(DiagTest diagTest) throws Exception {
		dao.update(diagTest);

	}


	public ArrayList<DiagTest> findByTestCd(String issueCd) throws Exception {
	return	dao.findByTestCd(issueCd);

	}

		}
