package com.pervacio.adminportal.tradein.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DevPriceKey implements Serializable {



	private String companyName;

	private int tradeinDeviceId;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getTradeinDeviceId() {
		return tradeinDeviceId;
	}

	public void setTradeinDeviceId(int tradeinDeviceId) {
		this.tradeinDeviceId = tradeinDeviceId;
	}

}
