package com.pervacio.adminportal.lookup.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class LookUpKey implements Serializable {
	private String lookUpType;
	private String lookUpValue;
	public String getLookUpType() {
		return lookUpType;
	}
	public void setLookUpType(String lookUpType) {
		this.lookUpType = lookUpType;
	}
	public String getLookUpValue() {
		return lookUpValue;
	}
	public void setLookUpValue(String lookUpValue) {
		this.lookUpValue = lookUpValue;
	}
	
	
}
