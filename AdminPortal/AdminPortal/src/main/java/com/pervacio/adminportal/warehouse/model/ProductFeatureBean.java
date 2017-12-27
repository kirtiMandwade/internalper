package com.pervacio.adminportal.warehouse.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.pervacio.adminportal.warehouse.entities.ProductFeatureId;

public class ProductFeatureBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private ProductFeatureId productFeatureId;

	private String introducedVersion;

	private Timestamp creationDttm;
	private Timestamp lastUpdatedDttm;

	public ProductFeatureId getProductFeatureId() {
		return productFeatureId;
	}
	public void setProductFeatureId(ProductFeatureId productFeatureId) {
		this.productFeatureId = productFeatureId;
	}
	public String getIntroducedVersion() {
		return introducedVersion;
	}
	public void setIntroducedVersion(String introducedVersion) {
		this.introducedVersion = introducedVersion;
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

}