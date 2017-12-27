package com.pervacio.adminportal.care.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.care.dao.EModelDao;
import com.pervacio.adminportal.care.entities.EModel;


@Service
public class EModelManagerImpl implements EModelManager {

	@Autowired
	EModelDao dao;

		public List<EModel> getAll()  {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(EModel EModel) throws Exception {
		// TODO Auto-generated method stub
		dao.add(EModel);
	}

	public void remove(EModel wsProfile) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(wsProfile);
	}

	public void update(EModel EModel) throws Exception {
		// TODO Auto-generated method stub
		dao.update(EModel);
	};
	public ArrayList<EModel> getEModelByModel(String model) throws Exception{
		return dao.getEModelByModel(model);
	}
}
