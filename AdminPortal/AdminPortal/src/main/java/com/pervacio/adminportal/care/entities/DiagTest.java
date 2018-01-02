package com.pervacio.adminportal.care.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pervacio.adminportal.tradein.entities.DevicePrice;

@Entity
@Table(name = "diag_test")
public class DiagTest  extends AuditBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String testCd;
	private int androidSupported;
	private int iosSupported;
	private String testType;
	private int orderNum;
	private String categoryCd;


	@OneToMany(mappedBy = "diagTest",cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<DiagTestCompanyMap> diagTestCompanyMaps = new ArrayList<DiagTestCompanyMap>();


	public String getTestCd() {
		return testCd;
	}

	public void setTestCd(String testCd) {
		this.testCd = testCd;
	}

	public int getAndroidSupported() {
		return androidSupported;
	}

	public void setAndroidSupported(int androidSupported) {
		this.androidSupported = androidSupported;
	}

	

	public int getIosSupported() {
		return iosSupported;
	}

	public void setIosSupported(int iosSupported) {
		this.iosSupported = iosSupported;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getCategoryCd() {
		return categoryCd;
	}

	public void setCategoryCd(String categoryCd) {
		this.categoryCd = categoryCd;
	}

}