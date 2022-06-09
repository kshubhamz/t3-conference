package com.techleap.conference.model;

import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TICKET_TYPES")
public class TicketType {

	@Id
	@Column(name = "TICKET_TYPE_CODE")
	private String ticketTypeCode;

	@Column(name = "TICKET_TYPE_NAME")
	private String ticketTypeName;

	@Column(name = "TICKET_TYPE_DESC")
	private String description;

	@Column(name = "INCLUDES_WORKSHOP")
	private Boolean includesWorkshop;

	@JsonIgnore
	@OneToMany(mappedBy = "ticketType")
	private List<TicketPrice> ticketPrices;

	public String getTicketTypeCode() {
		return ticketTypeCode;
	}

	public void setTicketTypeCode(String ticketTypeCode) {
		this.ticketTypeCode = ticketTypeCode;
	}

	public String getTicketTypeName() {
		return ticketTypeName;
	}

	public void setTicketTypeName(String ticketTypeName) {
		this.ticketTypeName = ticketTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIncludesWorkshop() {
		return includesWorkshop;
	}

	public void setIncludesWorkshop(Boolean includesWorkshop) {
		this.includesWorkshop = includesWorkshop;
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
				"TicketType: { ticketTypeCode: %s, ticketTypeName: %s, description: %s, includesWorkshop: %s }",
				ticketTypeCode, ticketTypeName, description, includesWorkshop);
	}

}
