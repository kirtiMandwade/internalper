package com.pervacio.adminportal.warehouse.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
@Embeddable
public class ProductFeatureId implements Serializable{
	private String featureCd;
	private String productCd;
	public String getFeatureCd() {
		return featureCd;
	}
	public void setFeatureCd(String featureCd) {
		this.featureCd = featureCd;
	}
	public String getProductCd() {
		return productCd;
	}
	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}
	


}
