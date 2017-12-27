package com.pervacio.adminportal.care.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditBase {

	@Column(columnDefinition="TIMESTAMP  DEFAULT CURRENT_TIMESTAMP",updatable=false)
	private Timestamp creationDttm;
	@Column(columnDefinition="TIMESTAMP")
	private Timestamp lastUpdatedDttm;



	@PrePersist
	protected void onPrePersist() {
		creationDttm= new Timestamp(new Date().getTime());
	}


	@PreUpdate
	protected void onPreUpdate() {
		lastUpdatedDttm= new Timestamp(new Date().getTime());
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


}


