package com.pervacio.adminportal.warehouse.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class WorkStationFeatureId implements Serializable{
	private int workStationId;
	private String featureCd;
	public int getWorkStationId() {
		return workStationId;
	}
	public void setWorkStationId(int workStationId) {
		this.workStationId = workStationId;
	}
	public String getFeatureCd() {
		return featureCd;
	}
	public void setFeatureCd(String featureCd) {
		this.featureCd = featureCd;
	}
	

}
