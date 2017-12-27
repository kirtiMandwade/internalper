package com.pervacio.adminportal.warehouse.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.pervacio.adminportal.warehouse.entities.Feature;
import com.pervacio.adminportal.warehouse.entities.WorkStation;
import com.pervacio.adminportal.warehouse.entities.WorkStationFeatureId;

public class WorkStationFeatureBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private WorkStationFeatureId workStationFeatureId;

	private String featureValue;
	private Feature feature;
	private WorkStation workStation;

	private Timestamp creationDttm;
	private Timestamp lastUpdatedDttm;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



	public WorkStationFeatureId getWorkStationFeatureId() {
		return workStationFeatureId;
	}
	public void setWorkStationFeatureId(WorkStationFeatureId workStationFeatureId) {
		this.workStationFeatureId = workStationFeatureId;
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
	public WorkStation getWorkStation() {
		return workStation;
	}
	public void setWorkStation(WorkStation workStation) {
		this.workStation = workStation;
	}

}