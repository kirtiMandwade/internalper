package com.pervacio.adminportal.warehouse.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class ProfileFeatureId implements Serializable{
	private String featureCd;

private WSProfileId wsProfileId;

	public String getFeatureCd() {
		return featureCd;
	}
	public void setFeatureCd(String featureCd) {
		this.featureCd = featureCd;
	}
	public WSProfileId getWsProfileId() {
		return wsProfileId;
	}
	public void setWsProfileId(WSProfileId wsProfileId) {
		this.wsProfileId = wsProfileId;
	}

}
