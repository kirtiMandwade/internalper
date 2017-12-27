package com.pervacio.adminportal.care.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "euser")
public class EUser implements UserDetails,Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(columnDefinition="BIGINT(20)")
	private int userInternalId;

	@Column(columnDefinition="BIGINT(20)")
	private int companyId;

	@Column(columnDefinition="int(11)")
	private int userSource;

	private Date lastConnectedDate;
	private Date createDate;

	private Date lastDate;

	@Column(columnDefinition="int(11)")
	private int isUserEnabled;

	@Column(name = "UserId",columnDefinition="CHAR(50)")
	private String userId;

	@Column(name = "Password",columnDefinition="CHAR(64)")
	private String password;


	@Column(columnDefinition="int(11)")
	private int isLoginPromptEnabled;

	@Column(columnDefinition="int(11)")
	private int isPasswordChangeRequired;

	@Column(name = "FirstName",length=50)
	private String firstName;

	@Column(name = "LastName",length=50)
	private String lastName;

	@Column(name = "PhoneNumber",length=50)
	private String phoneNumber;

	@Column(name = "AlternatePhoneNumber",length=50)
	private String alternatePhoneNumber;
	@Column(name = "PhoneExtension",length=10)
	private String phoneExtension;
	@Column(name = "Email",length=255)
	private String email;
	@Column(name = "AlternateEmail",length=255)
	private String alternateEmail;

	@Column(name = "Department",length=50)
	private String department;

	@Column(name = "Division",length=50)
	private String division;

	@Column(name = "Location",length=255)
	private String location;

	@Column(name = "Address",length=255)
	private String address;


	@Column(name = "Unit",length=50)
	private String unit;


	public int getUserInternalId() {
		return userInternalId;
	}


	public void setUserInternalId(int userInternalId) {
		this.userInternalId = userInternalId;
	}


	public int getCompanyId() {
		return companyId;
	}


	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
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


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


}