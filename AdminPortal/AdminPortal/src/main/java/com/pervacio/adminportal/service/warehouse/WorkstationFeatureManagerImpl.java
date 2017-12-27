package com.pervacio.adminportal.service.warehouse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.warehouse.dao.WorkstationFeatureDao;
import com.pervacio.adminportal.warehouse.entities.WorkStationFeature;
import com.pervacio.adminportal.warehouse.model.WorkStationFeatureBean;


@Service
public class WorkstationFeatureManagerImpl implements WorkstationFeatureManager {

	@Autowired
	private WorkstationFeatureDao dao;

		public List<WorkStationFeature> getAll()  {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(WorkStationFeature workStationFeature) throws Exception {
		// TODO Auto-generated method stub
		dao.add(workStationFeature);
	}

	public void addWorkStationFeatureList(ArrayList<WorkStationFeature> workStationFeature) throws Exception{
		dao.addWorkStationFeatureList(workStationFeature);
	}

	public void remove(WorkStationFeature workStationFeature) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(workStationFeature);
	}

	public void update(WorkStationFeature workStationFeature) throws Exception {
		// TODO Auto-generated method stub
		dao.update(workStationFeature);
	};
	public ArrayList<WorkStationFeature> getWorkStationFeatureByFeatureValue(String featureValue) throws Exception{
		return dao.getWorkStationFeatureByFeatureValue(featureValue);
	}
}
