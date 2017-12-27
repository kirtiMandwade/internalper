package com.pervacio.adminportal.tradein.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TradeInDevice")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(columnDefinition="BIGINT(11)")
	private int tradeinDeviceId;

	@Column(length=50)
	private String make;
	private String model;
	private String storage;
	private String color;
	@Column(name = "Charger",columnDefinition="CHAR(1)")
	private String charger;

	@Column(columnDefinition="TIMESTAMP  DEFAULT CURRENT_TIMESTAMP",updatable=false)
	private Timestamp creationDttm;
	@Column(columnDefinition="TIMESTAMP")
	private Timestamp lastUpdatedDttm;

	@OneToMany(mappedBy = "deviceEntity",cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<DevicePrice> devicePriceEntities = new ArrayList<DevicePrice>();



	@OneToMany(mappedBy = "device")
	@JsonIgnore
	private List<DevicePromotion> devicePromotion = new ArrayList<DevicePromotion>();



	public int getTradeinDeviceId() {
		return tradeinDeviceId;
	}



	public void setTradeinDeviceId(int tradeinDeviceId) {
		this.tradeinDeviceId = tradeinDeviceId;
	}



	public String getMake() {
		return make;
	}



	public void setMake(String make) {
		this.make = make;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getStorage() {
		return storage;
	}



	public void setStorage(String storage) {
		this.storage = storage;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getCharger() {
		return charger;
	}



	public void setCharger(String charger) {
		this.charger = charger;
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



	public List<DevicePrice> getDevicePriceEntities() {
		return devicePriceEntities;
	}



	public void setDevicePriceEntities(List<DevicePrice> devicePriceEntities) {
		this.devicePriceEntities = devicePriceEntities;
	}



	public List<DevicePromotion> getDevicePromotion() {
		return devicePromotion;
	}



	public void setDevicePromotion(List<DevicePromotion> devicePromotion) {
		this.devicePromotion = devicePromotion;
	}

}