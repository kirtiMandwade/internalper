package com.pervacio.adminportal.tradein.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pervacio.adminportal.care.entities.AuditBase;

@Entity
@Table(name = "DevicePrice")
public class DevicePrice extends AuditBase implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * @Id
	 *
	 * @Column(name = "CompanyName") private String companyName;
	 *
	 * @Id
	 *
	 * @ManyToOne
	 *
	 * @JoinColumn(name = "TradeinDeviceId", referencedColumnName =
	 * "TradeinDeviceId") private Device deviceEntity;
	 */
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "companyName", column = @Column(name = "companyName")),
			@AttributeOverride(name = "tradeinDeviceId", column = @Column(name = "TradeinDeviceId")) })
	private DevPriceKey productPK;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TradeinDeviceId", referencedColumnName = "TradeinDeviceId", insertable = false, updatable = false)
	private Device deviceEntity;

	@Column(columnDefinition = "DECIMAL(8,2)")
	private Float basePrice;
	@Column(name = "Currency", length = 3, columnDefinition = "CHAR(3)")
	private String currency;

	public DevPriceKey getProductPK() {
		return productPK;
	}

	public void setProductPK(DevPriceKey productPK) {
		this.productPK = productPK;
	}

	public Device getDeviceEntity() {
		return deviceEntity;
	}

	public void setDeviceEntity(Device deviceEntity) {
		this.deviceEntity = deviceEntity;
	}

	public Float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Float basePrice) {
		this.basePrice = basePrice;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}



}