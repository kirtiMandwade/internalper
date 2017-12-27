package com.pervacio.adminportal.warehouse.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pervacio.adminportal.constants.DeductionType;

@Entity
@Table(name = "WorkStationFeature")
public class WorkStationFeature implements Serializable {
	private static final long serialVersionUID = 1L;

	/*@Id
	@GeneratedValue
	@Column(columnDefinition = "BIGINT(20)")
	private int workStationId;
*/
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "FeatureCd", column = @Column(name = "FeatureCd")),
		@AttributeOverride(name = "WorkStationId", column = @Column(name = "WorkStationId")) })
	private WorkStationFeatureId workStationFeatureId;

	 @JsonBackReference
	 @JoinColumn(name = "WorkStationId", referencedColumnName = "WorkStationId",insertable=false,updatable=false)
	 @ManyToOne(fetch = FetchType.LAZY)
	 private WorkStation workStation;
	 public WorkStation getWorkStation() {
	 return workStation;
	 }
	 public void setWorkStation(WorkStation workStation) {
	 this.workStation = workStation;
	 }
	@Column(length = 100)
	private String featureValue;

	@Column(columnDefinition = "TIMESTAMP  DEFAULT CURRENT_TIMESTAMP")
	private Timestamp creationDttm;
	@Column(columnDefinition = "TIMESTAMP")
	private Timestamp lastUpdatedDttm;


	@JoinColumn(name = "FeatureCd", referencedColumnName = "FeatureCd",insertable=false,updatable=false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Feature feature;
/*
	public int getWorkStationId() {
		return workStationId;
	}

	public void setWorkStationId(int workStationId) {
		this.workStationId = workStationId;
	}
*/
	public String getFeatureValue() {
		return featureValue;
	}

	public void setFeatureValue(String featureValue) {
		this.featureValue = featureValue;
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

	public Feature getFeature() {
		return feature;
	}

	public void setFea(Feature feature) {
		this.feature = feature;
	}
	public WorkStationFeatureId getWorkStationFeatureId() {
		return workStationFeatureId;
	}
	public void setWorkStationFeatureId(WorkStationFeatureId workStationFeatureId) {
		this.workStationFeatureId = workStationFeatureId;
	}
	public void setFeature(Feature feature) {
		this.feature = feature;
	}

}