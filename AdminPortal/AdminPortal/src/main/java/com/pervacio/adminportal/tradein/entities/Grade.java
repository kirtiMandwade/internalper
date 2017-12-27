package com.pervacio.adminportal.tradein.entities;

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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pervacio.adminportal.care.entities.AuditBase;
import com.pervacio.adminportal.constants.DeductionType;

@Entity
@Table(name = "Grade")
public class Grade  extends AuditBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "GradeCode", length = 2, columnDefinition = "CHAR(2)")
	private String gradeCode;

	private String gradeDesc;
	private String gradeDisplayName;
	@Column(columnDefinition = "DECIMAL(8,2)")
	private Float deductionValue;
	@Column(columnDefinition = "CHAR(1)")
	private String active;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Percentage', 'Value')")
	private DeductionType deductionType;



	@OneToMany(mappedBy = "gradeEntity", cascade = CascadeType.ALL)
	@JsonIgnore
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


	public List<DevicePromotion> getDevicePromotion() {
		return devicePromotion;
	}

	public void setDevicePromotion(List<DevicePromotion> devicePromotion) {
		this.devicePromotion = devicePromotion;
	}

}