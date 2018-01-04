package com.pervacio.adminportal.lookup.model;

import java.io.Serializable;

public class LookUpBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private int lookUpId;
	
	private String lookUpType;
	
	private String lookUpValue;
	
	private String lookUpName;

	public int getLookUpId() {
		return lookUpId;
	}

	public void setLookUpId(int lookUpId) {
		this.lookUpId = lookUpId;
	}

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

	public String getLookUpName() {
		return lookUpName;
	}

	public void setLookUpName(String lookUpName) {
		this.lookUpName = lookUpName;
	}
	
	
	
}
