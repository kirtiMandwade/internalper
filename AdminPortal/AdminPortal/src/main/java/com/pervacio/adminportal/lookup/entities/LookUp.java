package com.pervacio.adminportal.lookup.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lookup")
public class LookUp implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(columnDefinition="BIGINT(20)")
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
