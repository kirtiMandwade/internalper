package com.pervacio.adminportal.tradein.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pervacio.adminportal.constants.DeductionType;
import com.pervacio.adminportal.tradein.entities.DevicePromotion;

public class GradeBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String gradeCode;

	private String gradeDesc;
	private String gradeDisplayName;
	private Float deductionValue;
	private String active;
	private DeductionType deductionType;
	private Timestamp creationDttm;
	private Timestamp lastUpdatedDttm;

	private List<DevicePromotion> devicePromotion = new ArrayList<DevicePromotion>();

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getGradeDesc() {
		return gradeDesc;
	}

	public void setGradeDesc(String gradeDesc) {
		this.gradeDesc = gradeDesc;
	}

	public String getGradeDisplayName() {
		return gradeDisplayName;
	}

	public void setGradeDisplayName(String gradeDisplayName) {
		this.gradeDisplayName = gradeDisplayName;
	}

	public Float getDeductionValue() {
		return deductionValue;
	}

	public void setDeductionValue(Float deductionValue) {
		this.deductionValue = deductionValue;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public DeductionType getDeductionType() {
		return deductionType;
	}

	public void setDeductionType(DeductionType deductionType) {
		this.deductionType = deductionType;
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

	public List<DevicePromotion> getDevicePromotion() {
		return devicePromotion;
	}

	public void setDevicePromotion(List<DevicePromotion> devicePromotion) {
		this.devicePromotion = devicePromotion;
	}
}
