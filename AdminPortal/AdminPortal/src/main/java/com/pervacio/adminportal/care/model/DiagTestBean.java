package com.pervacio.adminportal.care.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.care.entities.DiagTestCompanyMap;
import com.pervacio.adminportal.lookup.entities.LookUp;

public class DiagTestBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String testCd;
	private int androidSupported;
	private int iosSupported;
	private LookUp testType;
	private LookUp orderNum;
	private LookUp categoryCd;

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

	public List<DiagTestCompanyMap> getDiagTestCompanyMaps() {
		return diagTestCompanyMaps;
	}

	public void setDiagTestCompanyMaps(List<DiagTestCompanyMap> diagTestCompanyMaps) {
		this.diagTestCompanyMaps = diagTestCompanyMaps;
	}

	public LookUp getTestType() {
		return testType;
	}

	public void setTestType(LookUp testType) {
		this.testType = testType;
	}

	public LookUp getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(LookUp orderNum) {
		this.orderNum = orderNum;
	}

	public LookUp getCategoryCd() {
		return categoryCd;
	}

	public void setCategoryCd(LookUp categoryCd) {
		this.categoryCd = categoryCd;
	}

	

}