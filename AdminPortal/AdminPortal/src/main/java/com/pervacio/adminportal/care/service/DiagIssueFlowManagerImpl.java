package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.care.dao.DiagIssueFlowDao;
import com.pervacio.adminportal.care.entities.DiagIssuesFlow;


@Service
public class DiagIssueFlowManagerImpl implements DiagIssueFlowManager {

	@Autowired
	DiagIssueFlowDao dao;

	public List<DiagIssuesFlow> getAll() {

		return dao.getAll();

	}

	public void add(DiagIssuesFlow diagIssuesFlow) throws Exception {
		dao.add(diagIssuesFlow);

	}

	public void remove(DiagIssuesFlow diagIssuesFlow) throws Exception {
		dao.remove(diagIssuesFlow);

	}

	public void update(DiagIssuesFlow diagIssuesFlow) throws Exception {
		dao.update(diagIssuesFlow);

	}


	public ArrayList<DiagIssuesFlow> findByIssueCd(String issueCd) throws Exception {
	return	dao.findByIssueCd(issueCd);

	}
}
