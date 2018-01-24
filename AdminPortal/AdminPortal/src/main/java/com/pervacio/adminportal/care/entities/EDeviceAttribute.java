package com.pervacio.adminportal.care.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.pervacio.adminportal.lookup.entities.LookUp;

@Entity
@Table(name = "edeviceattribute")
public class EDeviceAttribute extends AuditBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private String id;

	@Id
	@GeneratedValue
	@Column
	private int attributeId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "attributeNameType", referencedColumnName = "lookUpType"),
			@JoinColumn(name = "attributeName", referencedColumnName = "lookUpValue") })
	private LookUp attributeName;

	private String attributeValue;

	@ManyToOne
	@JoinColumn(name = "DeviceModelId", referencedColumnName = "DeviceModelId")
	private EModel eMod;

	public LookUp getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(LookUp attributeName) {
		this.attributeName = attributeName;
	}

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
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