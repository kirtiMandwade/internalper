package com.pervacio.adminportal.repository.care;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.care.entities.DiagIssuesFlow;

public interface DiagIssuesFlowRepository extends JpaRepository<DiagIssuesFlow, String>{
	public ArrayList<DiagIssuesFlow>findByIssueCd(String issueCd);
}
