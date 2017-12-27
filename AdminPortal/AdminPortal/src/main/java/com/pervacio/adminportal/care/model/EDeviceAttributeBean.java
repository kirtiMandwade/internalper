package com.pervacio.adminportal.care.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pervacio.adminportal.care.entities.EModel;

public class EDeviceAttributeBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int attributeId;

	private String attributeName;
	private String attributeValue;
	private EModel eMod;
	public int getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
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

}