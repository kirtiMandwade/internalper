package com.pervacio.adminportal.lookup.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pervacio.adminportal.care.entities.DiagTest;
import com.pervacio.adminportal.care.entities.DiagTestCompanyMap;
import com.pervacio.adminportal.care.entities.EDeviceAttribute;
import com.pervacio.adminportal.care.entities.EUser;

@Entity
@Table(name = "lookup")
public class LookUp implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "lookUpType", column = @Column(name = "lookUpType")),
			@AttributeOverride(name = "lookUpValue", column = @Column(name = "lookUpValue")) })
	private LookUpKey lookUpKey;

	@Column(columnDefinition = "varchar(255)")
	private String lookupDisplayName;
	@Column(columnDefinition = "varchar(512)")
	private String lookupDescription;

	@OneToMany(mappedBy = "testType", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<DiagTest> diagTesttestType = new ArrayList<DiagTest>();

	@OneToMany(mappedBy = "orderNum", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<DiagTest> diagTesorderNum = new ArrayList<DiagTest>();

	@OneToMany(mappedBy = "categoryCd", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<DiagTest> diagTestcategoryCd = new ArrayList<DiagTest>();

	/*
	 * @OneToMany(mappedBy = "orderNum", cascade = CascadeType.REMOVE)
	 * 
	 * @JsonIgnore private List<DiagIssuesFlow> diagIssuesFloworderNum = new
	 * ArrayList<DiagIssuesFlow>();
	 */

	@OneToMany(mappedBy = "productCd", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<DiagTestCompanyMap> diagTestCompanyMaps = new ArrayList<DiagTestCompanyMap>();

	@OneToMany(mappedBy = "severityCd", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<DiagTestCompanyMap> diagTestCompanyMaps1 = new ArrayList<DiagTestCompanyMap>();

	@OneToMany(mappedBy = "attributeName", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<EDeviceAttribute> eDeviceAttribute = new ArrayList<EDeviceAttribute>();

	@OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<EUser> eUserDepartment = new ArrayList<EUser>();

	@OneToMany(mappedBy = "unit", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<EUser> eUserDepartmentUnit = new ArrayList<EUser>();

	public List<EDeviceAttribute> geteDeviceAttribute() {
		return eDeviceAttribute;
	}

	public void seteDeviceAttribute(List<EDeviceAttribute> eDeviceAttribute) {
		this.eDeviceAttribute = eDeviceAttribute;
	}

	public List<DiagTestCompanyMap> getDiagTestCompanyMaps1() {
		return diagTestCompanyMaps1;
	}

	public void setDiagTestCompanyMaps1(List<DiagTestCompanyMap> diagTestCompanyMaps1) {
		this.diagTestCompanyMaps1 = diagTestCompanyMaps1;
	}

	public List<DiagTestCompanyMap> getDiagTestCompanyMaps() {
		return diagTestCompanyMaps;
	}

	public void setDiagTestCompanyMaps(List<DiagTestCompanyMap> diagTestCompanyMaps) {
		this.diagTestCompanyMaps = diagTestCompanyMaps;
	}

	public List<EUser> geteUserDepartment() {
		return eUserDepartment;
	}

	public void seteUserDepartment(List<EUser> eUserDepartment) {
		this.eUserDepartment = eUserDepartment;
	}

	public List<EUser> geteUserDepartmentUnit() {
		return eUserDepartmentUnit;
	}

	public void seteUserDepartmentUnit(List<EUser> eUserDepartmentUnit) {
		this.eUserDepartmentUnit = eUserDepartmentUnit;
	}

	/*
	 * @OneToMany(mappedBy = "lookUpUnit",cascade=CascadeType.REMOVE)
	 * 
	 * @JsonIgnore private List<EUser> eUserUnit = new ArrayList<EUser>();
	 */
	public LookUpKey getLookUpKey() {
		return lookUpKey;
	}

	public void setLookUpKey(LookUpKey lookUpKey) {
		this.lookUpKey = lookUpKey;
	}

	public String getLookupDisplayName() {
		return lookupDisplayName;
	}

	public void setLookupDisplayName(String lookupDisplayName) {
		this.lookupDisplayName = lookupDisplayName;
	}

	public String getLookupDescription() {
		return lookupDescription;
	}

	public void setLookupDescription(String lookupDescription) {
		this.lookupDescription = lookupDescription;
	}

	public List<DiagTest> getDiagTesttestType() {
		return diagTesttestType;
	}

	public void setDiagTesttestType(List<DiagTest> diagTesttestType) {
		this.diagTesttestType = diagTesttestType;
	}

	public List<DiagTest> getDiagTesorderNum() {
		return diagTesorderNum;
	}

	public void setDiagTesorderNum(List<DiagTest> diagTesorderNum) {
		this.diagTesorderNum = diagTesorderNum;
	}

	public List<DiagTest> getDiagTestcategoryCd() {
		return diagTestcategoryCd;
	}

	public void setDiagTestcategoryCd(List<DiagTest> diagTestcategoryCd) {
		this.diagTestcategoryCd = diagTestcategoryCd;
	}

	/*
	 * public List<DiagIssuesFlow> getDiagIssuesFloworderNum() { return
	 * diagIssuesFloworderNum; }
	 * 
	 * public void setDiagIssuesFloworderNum(List<DiagIssuesFlow>
	 * diagIssuesFloworderNum) { this.diagIssuesFloworderNum =
	 * diagIssuesFloworderNum; }
	 */
}
