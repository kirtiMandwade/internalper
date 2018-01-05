package com.pervacio.adminportal.care.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pervacio.adminportal.tradein.entities.Device;

@Entity
@Table(name = "app_config")
public class AppConfig extends AuditBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int configId;

/*	 @ManyToMany(cascade = { CascadeType.REMOVE },fetch=FetchType.EAGER)
	    @JoinTable(
	        name = "ecompanyConfig",
	        joinColumns = { @JoinColumn(name = "companyId") },
	        inverseJoinColumns = { @JoinColumn(name = "configId") }
	    )*/
	 @JoinColumn(name = "companyId", referencedColumnName = "companyId")
		@ManyToOne(fetch = FetchType.EAGER)
	private ECompany company;

	private String configKey;
	private String configValue;

	public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}



	public ECompany getCompany() {
		return company;
	}

	public void setCompany(ECompany company) {
		this.company = company;
	}

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

}