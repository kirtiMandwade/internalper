package com.pervacio.adminportal.warehouse.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pervacio.adminportal.warehouse.entities.ProfileFeature;
import com.pervacio.adminportal.warehouse.entities.ProfileFeatureId;

public interface ProfileFeatureRepository extends JpaRepository<ProfileFeature, ProfileFeatureId> {
	public ArrayList<ProfileFeature> findByFeatureValue(String ProfileFeature);

}
