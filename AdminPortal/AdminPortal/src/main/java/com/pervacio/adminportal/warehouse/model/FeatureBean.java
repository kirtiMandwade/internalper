package com.pervacio.adminportal.warehouse.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.pervacio.adminportal.constants.ValueType;

public class FeatureBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String featureCd;

	private String featureDesc;

	private ValueType valueType;

	private String choiceValues;

	private String defaultValue;
	private Timestamp creationDttm;
	private Timestamp lastUpdatedDttm;
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

}