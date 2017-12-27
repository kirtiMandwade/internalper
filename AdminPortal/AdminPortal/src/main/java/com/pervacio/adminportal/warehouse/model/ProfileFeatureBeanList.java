package com.pervacio.adminportal.warehouse.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.pervacio.adminportal.warehouse.entities.WSProfile;

public class ProfileFeatureBeanList implements Serializable {
	private static final long serialVersionUID = 1L;

	private Timestamp creationDttm;
	private Timestamp lastUpdatedDttm;

	private ArrayList<ProfileFeatureBean> fea;

	private WSProfile wsProfiles;

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

	public ArrayList<ProfileFeatureBean> getFea() {
		return fea;
	}

	public void setFea(ArrayList<ProfileFeatureBean> fea) {
		this.fea = fea;
	}

	public WSProfile getWsProfiles() {
		return wsProfiles;
	}

	public void setWsProfiles(WSProfile wsProfiles) {
		this.wsProfiles = wsProfiles;
	}

}