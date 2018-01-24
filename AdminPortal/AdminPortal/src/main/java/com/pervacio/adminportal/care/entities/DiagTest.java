package com.pervacio.adminportal.care.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pervacio.adminportal.lookup.entities.LookUp;
import com.pervacio.adminportal.tradein.entities.DevicePrice;

@Entity
@Table(name = "diag_test")
public class DiagTest  extends AuditBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String testCd;
	private int androidSupported;
	private int iosSupported;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name = "testTypeType", referencedColumnName = "lookUpType"),
		@JoinColumn(name = "testType", referencedColumnName = "lookUpValue")})
	private LookUp testType;
	
	private int orderNum;	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name = "categoryCdType", referencedColumnName = "lookUpType"),
		@JoinColumn(name = "categoryCd", referencedColumnName = "lookUpValue")})
	private LookUp categoryCd;

/*
	@OneToMany(mappedBy = "diagTest",cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<DiagTestCompanyMap> diagTestCompanyMaps = new ArrayList<DiagTestCompanyMap>();
*/
	
	 @ManyToMany(mappedBy = "diagTests")
	    private Set<DiagTestCompanyMap> diagTestCompanyMaps = new HashSet<>();

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

	public LookUp getTestType() {
		return testType;
	}

	public void setTestType(LookUp testType) {
		this.testType = testType;
	}

	
	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public LookUp getCategoryCd() {
		return categoryCd;
	}

	public void setCategoryCd(LookUp categoryCd) {
		this.categoryCd = categoryCd;
	}

	public Set<DiagTestCompanyMap> getDiagTestCompanyMap() {
		return diagTestCompanyMaps;
	}

	public void setDiagTestCompanyMap(Set<DiagTestCompanyMap> diagTestCompanyMaps) {
		this.diagTestCompanyMaps = diagTestCompanyMaps;
	}

	@Override
	public String toString() {
		return "DiagTest [testCd=" + testCd + ", androidSupported=" + androidSupported + ", iosSupported="
				+ iosSupported + ", testType=" + testType + ", orderNum=" + orderNum + ", categoryCd=" + categoryCd
				+ ", diagTestCompanyMaps=" + diagTestCompanyMaps + "]";
	}

	

}