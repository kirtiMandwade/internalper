package com.pervacio.adminportal.care.service;

import java.util.List;

import com.pervacio.adminportal.care.entities.DiagTestCompanyMap;


public interface DiagTestCompanyMapManager
{
	public List<DiagTestCompanyMap> getAll();
	public void add(DiagTestCompanyMap diagTestCompanyMap) throws Exception;
	public  void remove(DiagTestCompanyMap diagTestCompanyMap) throws Exception;
	public void update(DiagTestCompanyMap diagTestCompanyMap) throws Exception ;
	
	public List<DiagTestCompanyMap>findByCompanyName(String companyName)throws Exception;

}