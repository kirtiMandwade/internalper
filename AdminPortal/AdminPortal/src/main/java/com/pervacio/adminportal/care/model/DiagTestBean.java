package com.pervacio.adminportal.care.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.pervacio.adminportal.care.entities.DiagTestCompanyMap;

public class DiagTestBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String testCd;
	private int androidSupported;
	private int iosSupported;
	private String testType;
	private int orderNum;
	private String categoryCd;

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