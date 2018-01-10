package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.care.dao.DiagTestCompanyMapDao;
import com.pervacio.adminportal.care.entities.DiagTestCompanyMap;


@Service
public class DiagTestCompanyMapManagerImpl implements DiagTestCompanyMapManager {

	@Autowired
	DiagTestCompanyMapDao dao;

		public List<DiagTestCompanyMap> getAll()  {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(DiagTestCompanyMap DiagTestCompanyMap) throws Exception {
		// TODO Auto-generated method stub
		dao.add(DiagTestCompanyMap);
	}

	public void remove(DiagTestCompanyMap wsProfile) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(wsProfile);
	}

	public void update(DiagTestCompanyMap DiagTestCompanyMap) throws Exception {
		// TODO Auto-generated method stub
		dao.update(DiagTestCompanyMap);
	};
	public ArrayList<DiagTestCompanyMap> findAllByEcompanyCompanyName(String companyName){
		return dao.findAllByEcompanyCompanyName(companyName);
	}
}
