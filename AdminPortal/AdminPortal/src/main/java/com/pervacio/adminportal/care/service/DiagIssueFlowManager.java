package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.care.entities.DiagIssuesFlow;


public interface DiagIssueFlowManager
{
	public List<DiagIssuesFlow> getAll();
	public void add(DiagIssuesFlow diagIssuesFlow) throws Exception;
	public  void remove(DiagIssuesFlow diagIssuesFlow) throws Exception;
	public void update(DiagIssuesFlow diagIssuesFlow) throws Exception ;
	public ArrayList<DiagIssuesFlow> findByIssueCd(String issueCd) throws Exception;

}