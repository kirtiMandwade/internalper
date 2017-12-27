	package com.pervacio.adminportal.warehouse.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pervacio.adminportal.constants.DeductionType;
import com.pervacio.adminportal.constants.ValueType;

@Entity
@Table(name = "Feature")
public class Feature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length=50)
	private String featureCd;


	@Column(length=30)
	private String featureDesc;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('ADHOC', 'CHOICE','BOOLEAN','DATE')")
	private ValueType valueType;


	@Column(length=255)
	private String choiceValues;

	@Column(length=100)
	private String defaultValue;
	@Column(columnDefinition="TIMESTAMP  DEFAULT CURRENT_TIMESTAMP",updatable=false)
	private Timestamp creationDttm;
	@Column(columnDefinition="TIMESTAMP")
	private Timestamp lastUpdatedDttm;

	@OneToMany(mappedBy = "feature", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<WorkStationFeature> workStationFeatures = new ArrayList<WorkStationFeature>();

	@OneToMany(mappedBy = "feature", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<ProfileFeature> profileFeatures = new ArrayList<ProfileFeature>();

	public String getFeatureCd() {
		return featureCd;
	}

	public void setFeatureCd(String featureCd) {
		this.featureCd = featureCd;
	}

	public String getFeatureDesc() {
		return featureDesc;
	}

	public void setFeatureDesc(String featureDesc) {
		this.featureDesc = featureDesc;
	}

	public ValueType getValueType() {
		return valueType;
	}

	public void setValueType(ValueType valueType) {
		this.valueType = valueType;
	}

	public String getChoiceValues() {
		return choiceValues;
	}

	public void setChoiceValues(String choiceValues) {
		this.choiceValues = choiceValues;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
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

	public List<WorkStationFeature> getWorkStationFeatures() {
		return workStationFeatures;
	}

	public void setWorkStationFeatures(List<WorkStationFeature> workStationFeatures) {
		this.workStationFeatures = workStationFeatures;
	}

	public List<ProfileFeature> getProfileFeatures() {
		return profileFeatures;
	}

	public void setProfileFeatures(List<ProfileFeature> profileFeatures) {
		this.profileFeatures = profileFeatures;
	}


}