package com.pervacio.adminportal.care.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pervacio.adminportal.care.entities.DiagIssuesFlow;
import com.pervacio.adminportal.repository.care.DiagIssueFlowRepository;

@Repository
@Transactional
public class DiagIssueFlowDao
{

	@Autowired
	private DiagIssueFlowRepository diagRepo;

	public List<DiagIssuesFlow> getAll() {

		return diagRepo.findAll();

	}

	public void add(DiagIssuesFlow diagIssuesFlow) throws Exception {
		diagRepo.saveAndFlush(diagIssuesFlow);

	}

	public void remove(DiagIssuesFlow diagIssuesFlow) throws Exception {
		diagRepo.delete(diagIssuesFlow);

	}

	public void update(DiagIssuesFlow diagIssuesFlow) throws Exception {
		diagRepo.saveAndFlush(diagIssuesFlow);

	}


	public ArrayList<DiagIssuesFlow> findByIssueCd(String issueCd) throws Exception {
	return	diagRepo.findByIssueCd(issueCd);

	}

}