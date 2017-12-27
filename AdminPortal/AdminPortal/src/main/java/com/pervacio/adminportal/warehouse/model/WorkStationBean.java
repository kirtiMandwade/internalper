package com.pervacio.adminportal.warehouse.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.pervacio.adminportal.constants.DeductionType;
import com.pervacio.adminportal.warehouse.entities.WSProfile;
import com.pervacio.adminportal.warehouse.entities.WorkStationFeature;

public class WorkStationBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int workStationId;

	private String workStationName;

	private Date provisionedDate;
	private Date endDate;

	private String active;

	private Timestamp creationDttm;

	private Timestamp lastUpdatedDttm;

	private WSProfile wsProfile;
		
	
	private List<WorkStationFeature> workStationFeatures ; 
	
	public List<WorkStationFeature> getWorkStationFeatures() {
		return workStationFeatures;
	}

	public void setWorkStationFeatures(List<WorkStationFeature> workStationFeatures) {
		this.workStationFeatures = workStationFeatures;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getWorkStationId() {
		return workStationId;
	}

	public void setWorkStationId(int workStationId) {
		this.workStationId = workStationId;
	}

	public String getWorkStationName() {
		return workStationName;
	}

	public void setWorkStationName(String workStationName) {
		this.workStationName = workStationName;
	}

	public Date getProvisionedDate() {
		return provisionedDate;
	}

	public void setProvisionedDate(Date provisionedDate) {
		this.provisionedDate = provisionedDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
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

	public WSProfile getWsProfile() {
		return wsProfile;
	}

	public void setWsProfile(WSProfile wsProfile) {
		this.wsProfile = wsProfile;
	}

}