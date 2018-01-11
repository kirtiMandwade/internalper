package com.pervacio.adminportal.tradein.entities;

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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pervacio.adminportal.care.entities.AuditBase;
import com.pervacio.adminportal.care.entities.ECompany;
import com.pervacio.adminportal.constants.DeductionType;

@Entity
@Table(name = "promotion")
public class Promotion  extends AuditBase implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "companyName", column = @Column(name = "CompanyName")),
		@AttributeOverride(name = "promoCode", column = @Column(name = "PromoCode")) })
	private PromotionKey promotionKey;


	private String promoDesc;
	private int promoPriority;
	@Column(name = "DeviceSpecific", length = 1, columnDefinition = "CHAR(1)")
	private String deviceSpecific;
	@Column(name = "GradeSpecific", length = 1, columnDefinition = "CHAR(1)")
	private String gradeSpecific;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Percentage', 'Value')")
	private DeductionType deductionType;
	@Column(columnDefinition = "DECIMAL(8,2)")
	private Float value;
	@Column(columnDefinition = "TIMESTAMP")
	private Timestamp startDateTime;
	@Column(columnDefinition = "TIMESTAMP")
	private Timestamp endDateTime;


	@OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<DevicePromotion> devicePromotion = new ArrayList<DevicePromotion>();


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "companyName", referencedColumnName = "companyName", insertable = false, updatable = false)
	private ECompany eCompany;

	
	public String getPromoDesc() {
		return promoDesc;
	}

	public void setPromoDesc(String promoDesc) {
		this.promoDesc = promoDesc;
	}

	public int getPromoPriority() {
		return promoPriority;
	}

	public void setPromoPriority(int promoPriority) {
		this.promoPriority = promoPriority;
	}

	public String getDeviceSpecific() {
		return deviceSpecific;
	}

	public void setDeviceSpecific(String deviceSpecific) {
		this.deviceSpecific = deviceSpecific;
	}

	public String getGradeSpecific() {
		return gradeSpecific;
	}

	public void setGradeSpecific(String gradeSpecific) {
		this.gradeSpecific = gradeSpecific;
	}

	public DeductionType getDeductionType() {
		return deductionType;
	}

	public void setDeductionType(DeductionType deductionType) {
		this.deductionType = deductionType;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Timestamp getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Timestamp getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Timestamp endDateTime) {
		this.endDateTime = endDateTime;
	}



	public List<DevicePromotion> getDevicePromotion() {
		return devicePromotion;
	}

	public void setDevicePromotion(List<DevicePromotion> devicePromotion) {
		this.devicePromotion = devicePromotion;
	}

	public PromotionKey getPromotionKey() {
		return promotionKey;
	}

	public void setPromotionKey(PromotionKey promotionKey) {
		this.promotionKey = promotionKey;
	}

}