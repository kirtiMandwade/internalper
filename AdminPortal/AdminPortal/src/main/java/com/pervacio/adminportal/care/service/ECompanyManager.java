package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.care.entities.ECompany;


public interface ECompanyManager
{
	public List<ECompany> getAll();
	public void add(ECompany eCompany) throws Exception;
	public  void remove(ECompany eCompany) throws Exception;
	public void update(ECompany eCompany) throws Exception ;
	public ArrayList<ECompany> getECompanyByCompanyName(String companyName) throws Exception;

}