package com.pervacio.adminportal.warehouse.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ProfileFeature")
public class ProfileFeature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private String id;
/*	@Id
	@Column(length = 30)
	private String ProfileCd;

	@Id
	@Column(length = 50)
	private String FeatureCd;
*/
	@Column(length = 100)
	private String featureValue;

	@Column(columnDefinition = "TIMESTAMP  DEFAULT CURRENT_TIMESTAMP")
	private Timestamp creationDttm;
	@Column(columnDefinition = "TIMESTAMP")
	private Timestamp lastUpdatedDttm;

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "FeatureCd", column = @Column(name = "FeatureCd")),
		@AttributeOverride(name = "ProfileCd", column = @Column(name = "ProfileCd")),
		@AttributeOverride(name = "CompanyName", column = @Column(name = "CompanyName"))})
	private ProfileFeatureId profileFeatureId;


	@JoinColumn(name = "FeatureCd", referencedColumnName = "FeatureCd",insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Feature feature;

	@JoinColumns({ @JoinColumn(name = "ProfileCd", referencedColumnName = "ProfileCd",insertable = false, updatable = false),
			@JoinColumn(name = "CompanyName", referencedColumnName = "CompanyName",insertable = false, updatable = false) })
	@ManyToOne(fetch = FetchType.LAZY)
@JsonBackReference
	private WSProfile wsProfiles;



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFeatureValue() {
		return featureValue;
	}
	public void setFeatureValue(String featureValue) {
		this.featureValue = featureValue;
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
	public Feature getFeature() {
		return feature;
	}
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	public WSProfile getWsProfiles() {
		return wsProfiles;
	}
	public void setWsProfiles(WSProfile wsProfiles) {
		this.wsProfiles = wsProfiles;
	}
	public ProfileFeatureId getProfileFeatureId() {
		return profileFeatureId;
	}
	public void setProfileFeatureId(ProfileFeatureId profileFeatureId) {
		this.profileFeatureId = profileFeatureId;
	}

}