package com.pervacio.adminportal.tradein.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.pervacio.adminportal.constants.DeductionType;
import com.pervacio.adminportal.tradein.entities.Device;
import com.pervacio.adminportal.tradein.entities.DevicePrice;
import com.pervacio.adminportal.tradein.entities.Grade;
import com.pervacio.adminportal.tradein.entities.Promotion;

public class DevicePromotionBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int devicePromotionId;

	private Promotion promotionEntity;

	private Device deviceEntity;

	private Grade gradeEntity;

	private DeductionType deductionType;
	private Float value;
	private Timestamp creationDttm;

	private Timestamp lastUpdatedDttm;

	public int getDevicePromotionId() {
		return devicePromotionId;
	}

	public void setDevicePromotionId(int devicePromotionId) {
		this.devicePromotionId = devicePromotionId;
	}

	public Promotion getPromotionEntity() {
		return promotionEntity;
	}

	public void setPromotionEntity(Promotion promotionEntity) {
		this.promotionEntity = promotionEntity;
	}

	public Device getDeviceEntity() {
		return deviceEntity;
	}

	public void setDeviceEntity(Device deviceEntity) {
		this.deviceEntity = deviceEntity;
	}

	public Grade getGradeEntity() {
		return gradeEntity;
	}

	public void setGradeEntity(Grade gradeEntity) {
		this.gradeEntity = gradeEntity;
	}

	public DeductionType getDeductionType() {
		return deductionType;
	}

	public void setDeductionType(DeductionType deductionType) {
		this.deductionType = deductionType;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
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
