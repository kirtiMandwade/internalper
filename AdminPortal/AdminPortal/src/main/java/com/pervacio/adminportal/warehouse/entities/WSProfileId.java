package com.pervacio.adminportal.warehouse.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class WSProfileId implements Serializable {

	private String profileCd;

	private String companyName;

	public String getProfileCd() {
		return profileCd;
	}

	public void setProfileCd(String profileCd) {
		this.profileCd = profileCd;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	

}
