package com.pervacio.adminportal.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.warehouse.entities.WorkStationFeature;
import com.pervacio.adminportal.warehouse.entities.WorkStationFeatureId;

public interface WorkStationFeatureRepository extends JpaRepository<WorkStationFeature, WorkStationFeatureId>{
	
}
