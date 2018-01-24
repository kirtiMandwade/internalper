package com.pervacio.adminportal.care.model;

import java.io.Serializable;

import com.pervacio.adminportal.care.entities.EModel;
import com.pervacio.adminportal.lookup.entities.LookUp;

public class EDeviceAttributeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private int attributeId;

	private LookUp attributeName;

	private String attributeValue;
	private EModel eMod;

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public LookUp getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(LookUp attributeName) {
		this.attributeName = attributeName;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public EModel geteMod() {
		return eMod;
	}

	public void seteMod(EModel eMod) {
		this.eMod = eMod;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}