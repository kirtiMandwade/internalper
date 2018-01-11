package com.pervacio.adminportal.care.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.care.entities.AuditBase;
import com.pervacio.adminportal.tradein.entities.DevicePrice;
import com.pervacio.adminportal.tradein.entities.Promotion;

public class ECompanyBean extends AuditBase implements Serializable {
	private static final long serialVersionUID = 1L;

	private int companyId;

	private int primaryContactId;
	private String companyName;
	private String companyAddress;
	private String companyCity;
	private String companyState;
	private String companyZip;
	private String companyCountry;
	private String companyTitle;
	private String companyImageFilename;
	private String loginId;
	private String password;
	private List<DevicePrice> devicePrice;
	private List<Promotion> promotion;
	public List<DevicePrice> getDevicePrice() {
		return devicePrice;
	}

	public void setDevicePrice(List<DevicePrice> devicePrice) {
		this.devicePrice = devicePrice;
	}

	
	public List<Promotion> getPromotion() {
		return promotion;
	}

	public void setPromotion(List<Promotion> promotion) {
		this.promotion = promotion;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getPrimaryContactId() {
		return primaryContactId;
	}

	public void setPrimaryContactId(int primaryContactId) {
		this.primaryContactId = primaryContactId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public String getCompanyState() {
		return companyState;
	}

	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}

	public String getCompanyZip() {
		return companyZip;
	}

	public void setCompanyZip(String companyZip) {
		this.companyZip = companyZip;
	}

	public String getCompanyCountry() {
		return companyCountry;
	}

	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}

	public String getCompanyTitle() {
		return companyTitle;
	}

	public void setCompanyTitle(String companyTitle) {
		this.companyTitle = companyTitle;
	}

	public String getCompanyImageFilename() {
		return companyImageFilename;
	}

	public void setCompanyImageFilename(String companyImageFilename) {
		this.companyImageFilename = companyImageFilename;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}