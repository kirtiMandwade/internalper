package com.pervacio.adminportal.care.model;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pervacio.adminportal.care.entities.DiagIssuesFlow;
import com.pervacio.adminportal.care.entities.DiagTest;
import com.pervacio.adminportal.tradein.entities.Device;

public class DiagTestCompanyMapBean implements Serializable {

	private static final long serialVersionUID = 1L;


	private int id;
	private int companyId;
	private String productCd;
	private String severityCd;
	
private DiagIssuesFlow diagIissuesFlow;

	private DiagTest diagTest;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getProductCd() {
		return productCd;
	}

	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}

	public String getSeverityCd() {
		return severityCd;
	}

	public void setSeverityCd(String severityCd) {
		this.severityCd = severityCd;
	}

	public DiagIssuesFlow getDiagIissuesFlow() {
		return diagIissuesFlow;
	}

	public void setDiagIissuesFlow(DiagIssuesFlow diagIissuesFlow) {
		this.diagIissuesFlow = diagIissuesFlow;
	}

	public DiagTest getDiagTest() {
		return diagTest;
	}

	public void setDiagTest(DiagTest diagTest) {
		this.diagTest = diagTest;
	}

}