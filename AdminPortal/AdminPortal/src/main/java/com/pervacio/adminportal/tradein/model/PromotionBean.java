package com.pervacio.adminportal.tradein.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pervacio.adminportal.constants.DeductionType;
import com.pervacio.adminportal.tradein.entities.DevicePrice;
import com.pervacio.adminportal.tradein.entities.DevicePromotion;
import com.pervacio.adminportal.tradein.entities.PromotionKey;

public class PromotionBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private PromotionKey promotionKey;
	/*private String promoCode;
private String companyName;*/
//	private DevicePrice devicePriceEntity;
	private List<DevicePromotion> devicePromotion = new ArrayList<DevicePromotion>();

	private String promoDesc;
	private int promoPriority;
	private String deviceSpecific;
	private String gradeSpecific;
	private DeductionType deductionType;
	private Float value;

	private Timestamp startDateTime;
	private Timestamp endDateTime;
	private Timestamp creationDttm;
	private Timestamp lastUpdatedDttm;
	
	public List<DevicePromotion> getDevicePromotion() {
		return devicePromotion;
	}
	public void setDevicePromotion(List<DevicePromotion> devicePromotion) {
		this.devicePromotion = devicePromotion;
	}
	public String getPromoDesc() {
		return promoDesc;
	}
	public void setPromoDesc(String promoDesc) {
		this.promoDesc = promoDesc;
	}
	public int getPromoPriority() {
		return promoPriority;
	}
	public void setPromoPriority(int promoPriority) {
		this.promoPriority = promoPriority;
	}
	public String getDeviceSpecific() {
		return deviceSpecific;
	}
	public void setDeviceSpecific(String deviceSpecific) {
		this.deviceSpecific = deviceSpecific;
	}
	public String getGradeSpecific() {
		return gradeSpecific;
	}
	public void setGradeSpecific(String gradeSpecific) {
		this.gradeSpecific = gradeSpecific;
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
	public Timestamp getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}
	public Timestamp getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(Timestamp endDateTime) {
		this.endDateTime = endDateTime;
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
	public PromotionKey getPromotionKey() {
		return promotionKey;
	}
	public void setPromotionKey(PromotionKey promotionKey) {
		this.promotionKey = promotionKey;
	}
	
	}
