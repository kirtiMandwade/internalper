package com.pervacio.adminportal.lookup.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pervacio.adminportal.care.entities.EUser;

@Entity
@Table(name="lookup")
public class LookUp implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "lookUpType", column = @Column(name = "lookUpType")),
		@AttributeOverride(name = "lookUpValue", column = @Column(name = "lookUpValue")) })
	private LookUpKey lookUpKey;

	@Column(columnDefinition = "varchar(255)")
	private String lookupDisplayName;
	@Column(columnDefinition = "varchar(512)")
	private String lookupDescription;

	@OneToMany(mappedBy = "department",cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<EUser> eUserDepartment = new ArrayList<EUser>();

	@OneToMany(mappedBy = "unit",cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<EUser> eUserDepartmentUnit = new ArrayList<EUser>();



	/*@OneToMany(mappedBy = "lookUpUnit",cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<EUser> eUserUnit = new ArrayList<EUser>();
*/
	public LookUpKey getLookUpKey() {
		return lookUpKey;
	}
	public void setLookUpKey(LookUpKey lookUpKey) {
		this.lookUpKey = lookUpKey;
	}
	public String getLookupDisplayName() {
		return lookupDisplayName;
	}
	public void setLookupDisplayName(String lookupDisplayName) {
		this.lookupDisplayName = lookupDisplayName;
	}
	public String getLookupDescription() {
		return lookupDescription;
	}
	public void setLookupDescription(String lookupDescription) {
		this.lookupDescription = lookupDescription;
	}





}
