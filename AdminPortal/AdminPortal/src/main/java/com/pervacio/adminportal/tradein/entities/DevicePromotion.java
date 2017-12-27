package com.pervacio.adminportal.tradein.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

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

@Entity
@Table(name = "DevicePromotion")
public class DevicePromotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(columnDefinition = "BIGINT(11)")
	private int devicePromotionId;

	@JoinColumns({ @JoinColumn(name = "CompanyName", referencedColumnName = "CompanyName"),
			@JoinColumn(name = "PromoCode", referencedColumnName = "PromoCode") })
	@ManyToOne(fetch = FetchType.EAGER)
	private Promotion promotion;

	@JoinColumn(name = "GradeCode", referencedColumnName = "GradeCode")
	@ManyToOne(fetch = FetchType.EAGER)
	private Grade gradeEntity;

	@JoinColumn(name = "TradeinDeviceId", referencedColumnName = "TradeinDeviceId")
	@ManyToOne(fetch = FetchType.EAGER)
	private Device device;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Percentage', 'Value')")
	private DeductionType deductionType;
	@Column(columnDefinition = "DECIMAL(8,2)")
	private Float value;

	@Column(columnDefinition = "TIMESTAMP  DEFAULT CURRENT_TIMESTAMP")
	private Timestamp creationDttm;
	@Column(columnDefinition = "TIMESTAMP")
	private Timestamp lastUpdatedDttm;
	public int getDevicePromotionId() {
		return devicePromotionId;
	}
	public void setDevicePromotionId(int devicePromotionId) {
		this.devicePromotionId = devicePromotionId;
	}
	public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	public Grade getGradeEntity() {
		return gradeEntity;
	}
	public void setGradeEntity(Grade gradeEntity) {
		this.gradeEntity = gradeEntity;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
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