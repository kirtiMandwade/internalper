package com.pervacio.adminportal.warehouse.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.warehouse.entities.WorkStation;

public interface WorkStationRepository extends JpaRepository<WorkStation, Integer>{
	public ArrayList<WorkStation> findByWorkStationId(int workStationId);
	
	public ArrayList<WorkStation> findByWorkStationName(String workStationName);
}
