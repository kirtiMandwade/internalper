package com.pervacio.adminportal.warehouse.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.pervacio.adminportal.warehouse.entities.Feature;
import com.pervacio.adminportal.warehouse.entities.ProfileFeatureId;
import com.pervacio.adminportal.warehouse.entities.WSProfile;

public class ProfileFeatureBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;

	private ProfileFeatureId profileFeatureId;

	private Timestamp creationDttm;
	private Timestamp lastUpdatedDttm;
	private String featureValue;

	private Feature feature;

	private WSProfile wsProfiles;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProfileFeatureId getProfileFeatureId() {
		return profileFeatureId;
	}

	public void setProfileFeatureId(ProfileFeatureId profileFeatureId) {
		this.profileFeatureId = profileFeatureId;
	}

	public Timestamp getCreationDttm() {
		return creationDttm;
	}

	public void setCreationDttm(Timestamp creationDttm) {
		this.creationDttm = creationDttm;
	}

	public Timestamp getLastUpdatedDttm() {
		return lastUpdatedDttm;
	}

	public void setLastUpdatedDttm(Timestamp lastUpdatedDttm) {
		this.lastUpdatedDttm = lastUpdatedDttm;
	}

	public String getFeatureValue() {
		return featureValue;
	}

	public void setFeatureValue(String featureValue) {
		this.featureValue = featureValue;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public WSProfile getWsProfiles() {
		return wsProfiles;
	}

	public void setWsProfiles(WSProfile wsProfiles) {
		this.wsProfiles = wsProfiles;
	}

}