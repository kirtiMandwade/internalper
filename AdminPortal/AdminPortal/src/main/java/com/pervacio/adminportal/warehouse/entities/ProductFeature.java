	package com.pervacio.adminportal.warehouse.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pervacio.adminportal.constants.DeductionType;

@Entity
@Table(name = "ProductFeature")
public class ProductFeature implements Serializable {
	private static final long serialVersionUID = 1L;

	/*@Id
	@Column(length=50)
	private String featureCd;

	@Id
	@Column(length=30)
	private String productCd;
*/
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "featureCd", column = @Column(name = "featureCd")),
		@AttributeOverride(name = "productCd", column = @Column(name = "productCd")) })

	private ProductFeatureId productFeatureId;

	@Column(length=50)
	private String introducedVersion;


	@Column(columnDefinition="TIMESTAMP  DEFAULT CURRENT_TIMESTAMP",updatable=false)
	private Timestamp creationDttm;
	@Column(columnDefinition="TIMESTAMP")
	private Timestamp lastUpdatedDttm;
	
	
	/*public String getFeatureCd() {
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
	}*/
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