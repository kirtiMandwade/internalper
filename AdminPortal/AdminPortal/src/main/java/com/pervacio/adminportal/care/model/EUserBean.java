package com.pervacio.adminportal.care.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.pervacio.adminportal.care.entities.ECompany;
import com.pervacio.adminportal.lookup.entities.LookUp;

public class EUserBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int userInternalId;
	private ECompany eCompany;
	private LookUp department;
	private LookUp unit;
	private int userSource;
	private Date lastConnectedDate;
	private Date createDate;
	private Date lastDate;
	private int isUserEnabled;
	private String userId;
	private String password;
	private int isLoginPromptEnabled;
	private int isPasswordChangeRequired;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String alternatePhoneNumber;
	private String phoneExtension;
	private String email;
	private String alternateEmail;
	private String division;
	private String location;
	private String address;
	public ECompany geteCompany() {
		return eCompany;
	}
	public void seteCompany(ECompany eCompany) {
		this.eCompany = eCompany;
	}
	public LookUp getDepartment() {
		return department;
	}
	public void setDepartment(LookUp department) {
		this.department = department;
	}
	public LookUp getUnit() {
		return unit;
	}
	public void setUnit(LookUp unit) {
		this.unit = unit;
	}
	public int getUserSource() {
		return userSource;
	}
	public void setUserSource(int userSource) {
		this.userSource = userSource;
	}
	public Date getLastConnectedDate() {
		return lastConnectedDate;
	}
	public void setLastConnectedDate(Date lastConnectedDate) {
		this.lastConnectedDate = lastConnectedDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public int getIsUserEnabled() {
		return isUserEnabled;
	}
	public void setIsUserEnabled(int isUserEnabled) {
		this.isUserEnabled = isUserEnabled;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsLoginPromptEnabled() {
		return isLoginPromptEnabled;
	}
	public void setIsLoginPromptEnabled(int isLoginPromptEnabled) {
		this.isLoginPromptEnabled = isLoginPromptEnabled;
	}
	public int getIsPasswordChangeRequired() {
		return isPasswordChangeRequired;
	}
	public void setIsPasswordChangeRequired(int isPasswordChangeRequired) {
		this.isPasswordChangeRequired = isPasswordChangeRequired;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}
	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}
	public String getPhoneExtension() {
		return phoneExtension;
	}
	public void setPhoneExtension(String phoneExtension) {
		this.phoneExtension = phoneExtension;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUserInternalId() {
		return userInternalId;
	}
	public void setUserInternalId(int userInternalId) {
		this.userInternalId = userInternalId;
	}


}
