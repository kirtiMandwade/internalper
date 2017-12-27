package com.pervacio.adminportal.service.warehouse;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.warehouse.entities.WorkStationFeature;
import com.pervacio.adminportal.warehouse.model.WorkStationFeatureBean;


public interface WorkstationFeatureManager
{
	public List<WorkStationFeature> getAll();
	public void add(WorkStationFeature workStationFeature) throws Exception;
	public void addWorkStationFeatureList(ArrayList<WorkStationFeature> workStationFeature) throws Exception;
	public  void remove(WorkStationFeature workStationFeature) throws Exception;
	public void update(WorkStationFeature workStationFeature) throws Exception ;
	public ArrayList<WorkStationFeature> getWorkStationFeatureByFeatureValue(String featureValue) throws Exception;

}
