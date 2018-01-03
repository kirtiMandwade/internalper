package com.pervacio.adminportal.service.warehouse;

import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.warehouse.entities.WorkStation;


public interface WorkstationManager
{
	public List<WorkStation> getAll();
	public void add(WorkStation workStation) throws Exception;
	public  void remove(WorkStation workStation) throws Exception;
	public void update(WorkStation workStation) throws Exception ;
	
	public ArrayList<WorkStation> getWorkStationByWorkStationId(int workstationId) throws Exception;
	
	public ArrayList<WorkStation> getWorkStationByWorkStationName(String workStationName) throws Exception;
}
