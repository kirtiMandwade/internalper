package com.pervacio.adminportal.repository.warehouse;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.warehouse.entities.WorkStation;

public interface WorkStationRepository extends JpaRepository<WorkStation, Integer>{
	public ArrayList<WorkStation> findByWorkStationId(int workStationId);
}
