package com.pervacio.adminportal.warehouse.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pervacio.adminportal.constants.DeductionType;

@Entity
@Table(name = "WorkStation")
public class WorkStation implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@Column(columnDefinition = "BIGINT(20)")
	private int workStationId;


	@Column(length = 100)
	private String workStationName;


	private Date provisionedDate;
	private Date endDate;

	@Column(columnDefinition = "CHAR(1)")
	private String active;

	@Column(columnDefinition = "TIMESTAMP  DEFAULT CURRENT_TIMESTAMP")
	private Timestamp creationDttm;
	@Column(columnDefinition = "TIMESTAMP")
	private Timestamp lastUpdatedDttm;

	@JsonIgnore
	@JoinColumns({ @JoinColumn(name = "ProfileCd", referencedColumnName = "ProfileCd"),
			@JoinColumn(name = "CompanyName", referencedColumnName = "CompanyName") })
	@ManyToOne(fetch = FetchType.LAZY)

	private WSProfile wsProfile;

	@JsonManagedReference
	 @OneToMany(mappedBy = "workStation", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	 private List<WorkStationFeature> workStationFeatures = new ArrayList<WorkStationFeature>();

	 public List<WorkStationFeature> getWorkStationFeatures() {
	  return workStationFeatures;
	 }
	 public void setWorkStationFeatures(List<WorkStationFeature> workStationFeatures) {
	  this.workStationFeatures = workStationFeatures;
	 }

	public int getWorkStationId() {
		return workStationId;
	}


	public void setWorkStationId(int workStationId) {
		this.workStationId = workStationId;
	}


	public String getWorkStationName() {
		return workStationName;
	}


	public void setWorkStationName(String workStationName) {
		this.workStationName = workStationName;
	}


	public Date getProvisionedDate() {
		return provisionedDate;
	}


	public void setProvisionedDate(Date provisionedDate) {
		this.provisionedDate = provisionedDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getActive() {
		return active;
	}


	public void setActive(String active) {
		this.active = active;
	}


	public Timestamp getCreationDttm() {
		return creationDttm;
	}


	public void setCreationDttm(Timestamp creationDttm) {
		this.creationDttm = creationDttm;
	}


	public Timestamp getLast_updated_dttm() {
		return lastUpdatedDttm;
	}


	public void setLast_updated_dttm(Timestamp lastUpdatedDttm) {
		lastUpdatedDttm = lastUpdatedDttm;
	}


	public WSProfile getWsProfile() {
		return wsProfile;
	}


	public void setWsProfile(WSProfile wsProfile) {
		this.wsProfile = wsProfile;
	}

}