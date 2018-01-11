package com.pervacio.adminportal.care.model;

import java.io.Serializable;

import com.pervacio.adminportal.care.entities.ECompany;
import com.pervacio.adminportal.care.entities.EModel;

public class EDeviceTradeInBasePriceBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int priceId;

	private String basePrice;
	private ECompany company;
	

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
	
	

	public ECompany getCompany() {
		return company;
	}

	public void setCompany(ECompany company) {
		this.company = company;
	}

	public EModel geteModel() {
		return eModel;
	}

	public void seteModel(EModel eModel) {
		this.eModel = eModel;
	}

}