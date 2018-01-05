package com.pervacio.adminportal.care.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pervacio.adminportal.care.entities.ECompany;


public class AppConfigBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int configId;
	private List<ECompany> arrEcompany;

	private String configKey;
	private String configValue;

	public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}



	public List<ECompany> getArrEcompany() {
		return arrEcompany;
	}

	public void setArrEcompany(List<ECompany> arrEcompany) {
		this.arrEcompany = arrEcompany;
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