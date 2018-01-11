package com.pervacio.adminportal.warehouse.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.pervacio.adminportal.care.entities.ECompany;
import com.pervacio.adminportal.warehouse.entities.ProfileFeature;
import com.pervacio.adminportal.warehouse.entities.WSProfileId;

public class WSProfileBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private WSProfileId wsProfileId;
	/*private String profileCd;

	private String companyName;*/
	private ECompany ecompany;
	private String profileDesc;

	private Timestamp creationDttm;
	private Timestamp lastUpdatedDttm;

	private List<ProfileFeature> profileFeatures;



	public WSProfileId getWsProfileId() {
		return wsProfileId;
	}

	public void setWsProfileId(WSProfileId wsProfileId) {
		this.wsProfileId = wsProfileId;
	}

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

	public List<ProfileFeature> getProfileFeatures() {
		return profileFeatures;
	}

	public void setProfileFeatures(List<ProfileFeature> profileFeatures) {
		this.profileFeatures = profileFeatures;
	}

	public ECompany getEcompany() {
		return ecompany;
	}

	public void setEcompany(ECompany ecompany) {
		this.ecompany = ecompany;
	}



}