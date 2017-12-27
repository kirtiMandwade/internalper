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

@Entity
@Table(name = "diag_issues_flow")
public class DiagIssuesFlow extends AuditBase implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	private String issueCd;
	private int orderNum;

	private int status;



	@OneToMany(mappedBy = "diagIissuesFlow",cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<DiagTestCompanyMap> diagTestCompanyMaps = new ArrayList<DiagTestCompanyMap>();


	public String getIssueCd() {
		return issueCd;
	}

	public void setIssueCd(String issueCd) {
		this.issueCd = issueCd;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}