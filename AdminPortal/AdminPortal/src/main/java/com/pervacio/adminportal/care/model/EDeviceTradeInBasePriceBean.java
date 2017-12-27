package com.pervacio.adminportal.care.model;

import java.io.Serializable;

import com.pervacio.adminportal.care.entities.EModel;

public class EDeviceTradeInBasePriceBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int priceId;

	private String basePrice;
	private String companyName;

	private EModel eModel;

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public String getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public EModel geteModel() {
		return eModel;
	}

	public void seteModel(EModel eModel) {
		this.eModel = eModel;
	}

}