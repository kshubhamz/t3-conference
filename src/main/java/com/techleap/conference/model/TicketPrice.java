package com.techleap.conference.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TICKET_PRICES")
@NamedQuery(name = "TicketPrice.getTicketsByTicketPricingCategory",
		query = "select tp from TicketPrice tp where tp.pricingCategory.pricingCategoryName = :priceCategoryName")
@NamedNativeQuery(name = "TicketPrice.getTicketsByCategoryWithWorkshop",
		query = "select tp.* from TICKET_PRICES tp " + 
				"left join TICKET_TYPES tt on tp.TICKET_TYPE_CODE = tt.TICKET_TYPE_CODE " + 
				"left join PRICING_CATEGORIES pc on tp.PRICING_CATEGORY_CODE = pc.PRICING_CATEGORY_CODE " +
				"where tt.INCLUDES_WORKSHOP = true and pc.PRICING_CATEGORY_NAME = :priceCategoryName",
		resultClass = TicketPrice.class)
public class TicketPrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TICKET_PRICE_ID")
	private Long ticketPriceId;

	@Column(name = "BASE_PRICE")
	private BigDecimal basePrice;

	@ManyToOne
	@JoinColumn(name = "TICKET_TYPE_CODE", nullable = false, updatable = false)
	private TicketType ticketType;

	@ManyToOne
	@JoinColumn(name = "PRICING_CATEGORY_CODE", nullable = false, updatable = false)
	private PricingCategory pricingCategory;

	public Long getTicketPriceId() {
		return ticketPriceId;
	}

	public void setTicketPriceId(Long ticketPriceId) {
		this.ticketPriceId = ticketPriceId;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public PricingCategory getPricingCategory() {
		return pricingCategory;
	}

	public void setPricingCategory(PricingCategory pricingCategory) {
		this.pricingCategory = pricingCategory;
	}

	@Override
	public String toString() {
		return String.format("TicketPrice: { ticketPriceId: %s, basePrice: %s }", ticketPriceId, basePrice);
	}

}
