
package com.pervacio.adminportal.care.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pervacio.adminportal.tradein.entities.DevicePrice;
import com.pervacio.adminportal.tradein.entities.Promotion;
import com.pervacio.adminportal.warehouse.entities.WSProfile;

@Entity
@Table(name = "ecompany")
public class ECompany extends AuditBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column
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

	@Transient
	@JsonIgnore
	@OneToMany(mappedBy = "company",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	private List<EDeviceTradeInBasePrice> deviceTradeInBasePrices = new ArrayList<EDeviceTradeInBasePrice>();

	@OneToMany(mappedBy = "company",cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<DiagTestCompanyMap> diagTestCompanyMaps = new ArrayList<DiagTestCompanyMap>();

	@OneToMany(mappedBy = "ecompany",cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<WSProfile> arrWsprofiles = new ArrayList<WSProfile>();

	@OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<AppConfig> arrAppConfig = new ArrayList<>();

	@OneToMany(mappedBy = "eCompany", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<EUser> eUser = new ArrayList<EUser>();

	
	@OneToMany(mappedBy = "eCompany", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<DevicePrice> devicePrice = new ArrayList<DevicePrice>();
	
	
	@OneToMany(mappedBy = "eCompany", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Promotion> promotion = new ArrayList<Promotion>();
	

	public List<EDeviceTradeInBasePrice> getDeviceTradeInBasePrices() {
		return deviceTradeInBasePrices;
	}

	public void setDeviceTradeInBasePrices(List<EDeviceTradeInBasePrice> deviceTradeInBasePrices) {
		this.deviceTradeInBasePrices = deviceTradeInBasePrices;
	}

	public List<DiagTestCompanyMap> getDiagTestCompanyMaps() {
		return diagTestCompanyMaps;
	}

	public void setDiagTestCompanyMaps(List<DiagTestCompanyMap> diagTestCompanyMaps) {
		this.diagTestCompanyMaps = diagTestCompanyMaps;
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

	public List<AppConfig> getArrAppConfig() {
		return arrAppConfig;
	}

	public void setArrAppConfig(List<AppConfig> arrAppConfig) {
		this.arrAppConfig = arrAppConfig;
	}

	public List<EUser> geteUser() {
		return eUser;
	}

	public void seteUser(List<EUser> eUser) {
		this.eUser = eUser;
	}

	public List<WSProfile> getArrWsprofiles() {
		return arrWsprofiles;
	}

	public void setArrWsprofiles(List<WSProfile> arrWsprofiles) {
		this.arrWsprofiles = arrWsprofiles;
	}

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

}