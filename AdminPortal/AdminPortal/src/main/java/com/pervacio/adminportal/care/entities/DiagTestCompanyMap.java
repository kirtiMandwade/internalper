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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pervacio.adminportal.tradein.entities.Device;

@Entity
@Table(name = "diag_test_company_map")
public class DiagTestCompanyMap  extends AuditBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	private int companyId;
	private String productCd;
	private String severityCd;


	@ManyToOne
	@JoinColumn(name = "issueCd", referencedColumnName = "issueCd")
	private DiagIssuesFlow diagIissuesFlow;

	@ManyToOne
	@JoinColumn(name = "testCd", referencedColumnName = "testCd")
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