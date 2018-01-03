package com.pervacio.adminportal.warehouse.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.warehouse.entities.Feature;
import com.pervacio.adminportal.warehouse.entities.WSProfile;
import com.pervacio.adminportal.warehouse.entities.WorkStation;

public interface FeatureRepository extends JpaRepository<Feature, String> {
	
	public ArrayList<Feature> findByFeatureCd(String featureCd);
}