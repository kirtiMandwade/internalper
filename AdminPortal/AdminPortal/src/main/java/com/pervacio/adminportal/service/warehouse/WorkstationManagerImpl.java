package com.pervacio.adminportal.service.warehouse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pervacio.adminportal.warehouse.dao.WorkstationDao;
import com.pervacio.adminportal.warehouse.entities.WorkStation;
import com.pervacio.adminportal.warehouse.entities.WorkStationFeature;
import com.pervacio.adminportal.warehouse.entities.WorkStationFeatureId;


@Service
public class WorkstationManagerImpl implements WorkstationManager {

	@Autowired
	private WorkstationDao dao;


		public List<WorkStation> getAll()  {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	public void add(WorkStation workStation) throws Exception {


		// TODO Auto-generated method stub
		for(WorkStationFeature work : workStation.getWorkStationFeatures())
		{
			WorkStationFeatureId  workId= new WorkStationFeatureId();

			workId.setFeatureCd(work.getFeature().getFeatureCd());
			workId.setWorkStationId(workStation.getWorkStationId());
			work.setWorkStationFeatureId(workId);
		}
			dao.add(workStation);
	}

	public void remove(WorkStation wsProfile) throws Exception{
		// TODO Auto-generated method stub
		dao.remove(wsProfile);
	}

	public void update(WorkStation workStation) throws Exception {


		for(WorkStationFeature work : workStation.getWorkStationFeatures())
		{
			WorkStationFeatureId  workId= new WorkStationFeatureId();

			workId.setFeatureCd(work.getFeature().getFeatureCd());
			workId.setWorkStationId(workStation.getWorkStationId());
			work.setWorkStationFeatureId(workId);
		}
		dao.update(workStation);
	};
	public ArrayList<WorkStation> getWorkStationByWorkStationId(int workstationId) throws Exception{
		return dao.getWorkStationByWorkStationId(workstationId);
	}
}
