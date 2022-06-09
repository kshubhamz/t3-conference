package com.techleap.conference.model;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PRICING_CATEGORIES")
public class PricingCategory {

	@Id
	@Column(name = "PRICING_CATEGORY_CODE")
	private String pricingCategoryCode;

	@Column(name = "PRICING_CATEGORY_NAME")
	private String pricingCategoryName;

	@Column(name = "PRICING_START_DATE")
	private Date pricingStartDate;

	@Column(name = "PRICING_END_DATE")
	private Date pricingEndDate;

	@JsonIgnore
	@OneToMany(mappedBy = "ticketType")
	private List<TicketPrice> ticketPrices;

	public String getPricingCategoryCode() {
		return pricingCategoryCode;
	}

	public void setPricingCategoryCode(String pricingCategoryCode) {
		this.pricingCategoryCode = pricingCategoryCode;
	}

	public String getPricingCategoryName() {
		return pricingCategoryName;
	}

	public void setPricingCategoryName(String pricingCategoryName) {
		this.pricingCategoryName = pricingCategoryName;
	}

	public Date getPricingStartDate() {
		return pricingStartDate;
	}

	public void setPricingStartDate(Date pricingStartDate) {
		this.pricingStartDate = pricingStartDate;
	}

	public Date getPricingEndDate() {
		return pricingEndDate;
	}

	public void setPricingEndDate(Date pricingEndDate) {
		this.pricingEndDate = pricingEndDate;
	}

	public List<TicketPrice> getTicketPrices() {
		return Collections.unmodifiableList(ticketPrices);
	}

	public void setTicketPrices(List<TicketPrice> ticketPrices) {
		this.ticketPrices = ticketPrices;
	}

	@Override
	public String toString() {
		return String.format(
				"PricingCategory: { pricingCategoryCode: %s, pricingCategoryName: %s, pricingStartDate: %s, pricingEndDate: %s }",
				pricingCategoryCode, pricingCategoryName, pricingStartDate, pricingEndDate);
	}

}
