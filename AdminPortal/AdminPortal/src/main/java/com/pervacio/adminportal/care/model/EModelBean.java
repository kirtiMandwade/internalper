package com.pervacio.adminportal.care.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pervacio.adminportal.care.entities.EDeviceAttribute;
import com.pervacio.adminportal.care.entities.EDeviceTradeInBasePrice;
import com.pervacio.adminportal.tradein.entities.DevicePrice;

public class EModelBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int deviceModelId;

	private int platformId;
	private int manufacturerId;
	private String modelNumber;
	private int countryId;
	private int networkTechnologyId;
	private int cableId;
	private int batteryId;
	private int chargerId;
	private int locationId;
	private int sourceId;
	private int shipmentId;
	private String modelCondition;
	private Date releaseDate;
	private int isAutoCreated;
	private Date createdAt;
	private Date updatedAt;
	private int isValid;
	private int initialFirmwareId;
	private int availability;
	private int batteryStatus;
	private int cableStatus;
	private String deviceImage;
	private int cost;
	private String weburlLink;
	private String modelName;
	private int defaultProfilePresent;
	private String deviceImageLocation;
	private String sourceProductCode;
	private String poNumber;
	private String manualInstructionDesc;
	private String description;
	private String defaultProfileFileName;
	private int defaultProfileLastUpdate;

	private List<EDeviceTradeInBasePrice> eDeviceTradeInBasePrices = new ArrayList<EDeviceTradeInBasePrice>();

	private List<EDeviceAttribute> eDeviceAttributes = new ArrayList<EDeviceAttribute>();

	public int getDeviceModelId() {
		return deviceModelId;
	}

	public void setDeviceModelId(int deviceModelId) {
		this.deviceModelId = deviceModelId;
	}

	public int getPlatformId() {
		return platformId;
	}

	public void setPlatformId(int platformId) {
		this.platformId = platformId;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getNetworkTechnologyId() {
		return networkTechnologyId;
	}

	public void setNetworkTechnologyId(int networkTechnologyId) {
		this.networkTechnologyId = networkTechnologyId;
	}

	public int getCableId() {
		return cableId;
	}

	public void setCableId(int cableId) {
		this.cableId = cableId;
	}

	public int getBatteryId() {
		return batteryId;
	}

	public void setBatteryId(int batteryId) {
		this.batteryId = batteryId;
	}

	public int getChargerId() {
		return chargerId;
	}

	public void setChargerId(int chargerId) {
		this.chargerId = chargerId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public String getModelCondition() {
		return modelCondition;
	}

	public void setModelCondition(String modelCondition) {
		this.modelCondition = modelCondition;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getIsAutoCreated() {
		return isAutoCreated;
	}

	public void setIsAutoCreated(int isAutoCreated) {
		this.isAutoCreated = isAutoCreated;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getIsValid() {
		return isValid;
	}

	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}

	public int getInitialFirmwareId() {
		return initialFirmwareId;
	}

	public void setInitialFirmwareId(int initialFirmwareId) {
		this.initialFirmwareId = initialFirmwareId;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public int getBatteryStatus() {
		return batteryStatus;
	}

	public void setBatteryStatus(int batteryStatus) {
		this.batteryStatus = batteryStatus;
	}

	public int getCableStatus() {
		return cableStatus;
	}

	public void setCableStatus(int cableStatus) {
		this.cableStatus = cableStatus;
	}

	public String getDeviceImage() {
		return deviceImage;
	}

	public void setDeviceImage(String deviceImage) {
		this.deviceImage = deviceImage;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getWeburlLink() {
		return weburlLink;
	}

	public void setWeburlLink(String weburlLink) {
		this.weburlLink = weburlLink;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getDefaultProfilePresent() {
		return defaultProfilePresent;
	}

	public void setDefaultProfilePresent(int defaultProfilePresent) {
		this.defaultProfilePresent = defaultProfilePresent;
	}

	public String getDeviceImageLocation() {
		return deviceImageLocation;
	}

	public void setDeviceImageLocation(String deviceImageLocation) {
		this.deviceImageLocation = deviceImageLocation;
	}

	public String getSourceProductCode() {
		return sourceProductCode;
	}

	public void setSourceProductCode(String sourceProductCode) {
		this.sourceProductCode = sourceProductCode;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getManualInstructionDesc() {
		return manualInstructionDesc;
	}

	public void setManualInstructionDesc(String manualInstructionDesc) {
		this.manualInstructionDesc = manualInstructionDesc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDefaultProfileFileName() {
		return defaultProfileFileName;
	}

	public void setDefaultProfileFileName(String defaultProfileFileName) {
		this.defaultProfileFileName = defaultProfileFileName;
	}

	public int getDefaultProfileLastUpdate() {
		return defaultProfileLastUpdate;
	}

	public void setDefaultProfileLastUpdate(int defaultProfileLastUpdate) {
		this.defaultProfileLastUpdate = defaultProfileLastUpdate;
	}

	public List<EDeviceTradeInBasePrice> geteDeviceTradeInBasePrices() {
		return eDeviceTradeInBasePrices;
	}

	public void seteDeviceTradeInBasePrices(List<EDeviceTradeInBasePrice> eDeviceTradeInBasePrices) {
		this.eDeviceTradeInBasePrices = eDeviceTradeInBasePrices;
	}

	public List<EDeviceAttribute> geteDeviceAttributes() {
		return eDeviceAttributes;
	}

	public void seteDeviceAttributes(List<EDeviceAttribute> eDeviceAttributes) {
		this.eDeviceAttributes = eDeviceAttributes;
	}



}