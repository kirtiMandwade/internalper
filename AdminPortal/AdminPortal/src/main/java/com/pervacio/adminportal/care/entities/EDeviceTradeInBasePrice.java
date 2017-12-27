package com.pervacio.adminportal.care.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pervacio.adminportal.tradein.entities.Device;

@Entity
@Table(name = "edevicetradeinbaseprice")
public class EDeviceTradeInBasePrice  extends AuditBase implements Serializable {
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue
	@Column
	private int priceId;

	private String basePrice;
	private String companyName;

	@ManyToOne
	@JoinColumn(name = "DeviceModelId", referencedColumnName = "DeviceModelId")
	private EModel eModel;

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public String getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public EModel geteModel() {
		return eModel;
	}

	public void seteModel(EModel eModel) {
		this.eModel = eModel;
	}

}