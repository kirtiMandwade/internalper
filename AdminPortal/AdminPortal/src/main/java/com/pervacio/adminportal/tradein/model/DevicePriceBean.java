package com.pervacio.adminportal.tradein.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.care.entities.ECompany;
import com.pervacio.adminportal.tradein.entities.DevPriceKey;
import com.pervacio.adminportal.tradein.entities.Device;
import com.pervacio.adminportal.tradein.entities.Promotion;

public class DevicePriceBean implements Serializable {
	private ECompany eCompany;
	public ECompany geteCompany() {
		return eCompany;
	}
	public void seteCompany(ECompany eCompany) {
		this.eCompany = eCompany;
	}
	public DevPriceKey devPriceKey;
	
	private Device deviceEntity;

	private Timestamp creationDttm;
	private Timestamp lastUpdatedDttm;

	private Float basePrice;
	private String currency;
	
	
	public Device getDeviceEntity() {
		return deviceEntity;
	}
	public void setDeviceEntity(Device deviceEntity) {
		this.deviceEntity = deviceEntity;
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
	public Float getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(Float basePrice) {
		this.basePrice = basePrice;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public DevPriceKey getDevPriceKey() {
		return devPriceKey;
	}
	public void setDevPriceKey(DevPriceKey devPriceKey) {
		this.devPriceKey = devPriceKey;
	}
	

}
