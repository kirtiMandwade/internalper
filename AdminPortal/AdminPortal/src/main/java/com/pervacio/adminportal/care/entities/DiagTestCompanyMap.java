package com.pervacio.adminportal.care.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pervacio.adminportal.lookup.entities.LookUp;

@Entity
@Table(name = "diag_test_company_map")
public class DiagTestCompanyMap extends AuditBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "companyId", referencedColumnName = "companyId")
	private ECompany company;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "productCdType", referencedColumnName = "lookUpType"),
			@JoinColumn(name = "productCd", referencedColumnName = "lookUpValue") })
	private LookUp productCd;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "severityCdType", referencedColumnName = "lookUpType"),
			@JoinColumn(name = "severityCd", referencedColumnName = "lookUpValue") })
	private LookUp severityCd;
	

	public LookUp getSeverityCd() {
		return severityCd;
	}

	public void setSeverityCd(LookUp severityCd) {
		this.severityCd = severityCd;
	}

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

	public DiagTest getDiagTest() {
		return diagTest;
	}

	public void setDiagTest(DiagTest diagTest) {
		this.diagTest = diagTest;
	}

}