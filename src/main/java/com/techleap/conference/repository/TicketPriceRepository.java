package com.techleap.conference.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techleap.conference.model.TicketPrice;

@Repository
public interface TicketPriceRepository extends JpaRepository<TicketPrice, Long> {
	@Query("select tp from TicketPrice tp where tp.basePrice < ?1 and tp.ticketType.includesWorkshop = true")
	public List<TicketPrice> getTicketsUnderPriceWithWorkshop(BigDecimal maxPrice);

	public List<TicketPrice> getTicketsByTicketPricingCategory(@Param("priceCategoryName") String pricingCategoryName);

	public List<TicketPrice> getTicketsByCategoryWithWorkshop(@Param("priceCategoryName") String pricingCategoryName);
}
