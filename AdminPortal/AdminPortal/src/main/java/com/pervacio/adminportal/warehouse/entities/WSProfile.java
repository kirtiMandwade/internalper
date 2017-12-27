package com.pervacio.adminportal.warehouse.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "WSProfile")
public class WSProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	/*@Id
	@Column(length = 30)
	private String profileCd;

	@Id
	@Column(length = 30)
	private String companyName;
*/
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "companyName", column = @Column(name = "companyName")),
		@AttributeOverride(name = "profileCd", column = @Column(name = "profileCd")) })
	private WSProfileId wsProfileId;

	@Column(length = 255)
	private String profileDesc;

	@Column(columnDefinition = "TIMESTAMP  DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private Timestamp creationDttm;
	@Column(columnDefinition = "TIMESTAMP")
	private Timestamp lastUpdatedDttm;

	@OneToMany(mappedBy = "wsProfile", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<WorkStation> workStations = new ArrayList<WorkStation>();

	@OneToMany(mappedBy = "wsProfiles", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonManagedReference
		private List<ProfileFeature> profileFeatures = new ArrayList<ProfileFeature>();

	/*public String getProfileCd() {
		return profileCd;
	}

	public void setProfileCd(String profileCd) {
		this.profileCd = profileCd;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
*/
	public String getProfileDesc() {
		return profileDesc;
	}

	public void setProfileDesc(String profileDesc) {
		this.profileDesc = profileDesc;
	}

	public Timestamp getCreationDttm() {
		return creationDttm;
	}

	public void setCreationDttm(Timestamp creationDttm) {
		this.creationDttm = creationDttm;
	}

	public Timestamp getLastUpdatedDttm() {
		return lastUpdatedDttm;
	}

	public void setLastUpdatedDttm(Timestamp lastUpdatedDttm) {
		this.lastUpdatedDttm = lastUpdatedDttm;
	}

	public List<WorkStation> getWorkStations() {
		return workStations;
	}

	public void setWorkStations(List<WorkStation> workStations) {
		this.workStations = workStations;
	}

	public List<ProfileFeature> getProfileFeatures() {
		return profileFeatures;
	}

	public void setProfileFeatures(List<ProfileFeature> profileFeatures) {
		this.profileFeatures = profileFeatures;
	}

	public WSProfileId getWsProfileId() {
		return wsProfileId;
	}

	public void setWsProfileId(WSProfileId wsProfileId) {
		this.wsProfileId = wsProfileId;
	}

}