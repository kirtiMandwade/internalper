package com.pervacio.adminportal.care.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.pervacio.adminportal.care.entities.DiagIssuesFlow;
import com.pervacio.adminportal.care.entities.DiagTest;
import com.pervacio.adminportal.care.entities.ECompany;
import com.pervacio.adminportal.lookup.entities.LookUp;

public class DiagTestCompanyMapBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private ECompany company;

	private LookUp productCd;
	private LookUp severityCd;
	

	public LookUp getSeverityCd() {
		return severityCd;
	}

	public void setSeverityCd(LookUp severityCd) {
		this.severityCd = severityCd;
	}

	private DiagIssuesFlow diagIissuesFlow;

	/*private DiagTest diagTest;*/
	private Set<DiagTest> diagTests = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ECompany getCompany() {
		return company;
	}

	public void setCompany(ECompany company) {
		this.company = company;
	}

	public LookUp getProductCd() {
		return productCd;
	}

	public void setProductCd(LookUp productCd) {
		this.productCd = productCd;
	}

	public DiagIssuesFlow getDiagIissuesFlow() {
		return diagIissuesFlow;
	}

	public void setDiagIissuesFlow(DiagIssuesFlow diagIissuesFlow) {
		this.diagIissuesFlow = diagIissuesFlow;
	}

	public Set<DiagTest> getDiagTests() {
		return diagTests;
	}

	public void setDiagTests(Set<DiagTest> diagTests) {
		this.diagTests = diagTests;
	}

}