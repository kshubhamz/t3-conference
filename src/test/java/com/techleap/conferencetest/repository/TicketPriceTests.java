package com.techleap.conferencetest.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.techleap.conference.model.TicketPrice;
import com.techleap.conference.repository.TicketPriceRepository;

@SpringBootTest
class TicketPriceTests {
	@Autowired
	private TicketPriceRepository repository;
	
	@Test
	void testQueryAnnotation() {
		BigDecimal maxPrice = BigDecimal.valueOf(1000);
		List<TicketPrice> tktPrice = repository
				.getTicketsUnderPriceWithWorkshop(maxPrice);
		assertEquals(-1, tktPrice.get(0).getBasePrice().compareTo(maxPrice));
		assertTrue(tktPrice.get(0).getTicketType().getIncludesWorkshop());
	}
	
	@Test
	void testNamedQueryWithQueryParam() {
		List<TicketPrice> tickets = repository.getTicketsByTicketPricingCategory("Regular");
		assertEquals("Regular", tickets.get(0).getPricingCategory().getPricingCategoryName());
	}
	
	@Test
	void testNativeNamedQueryWithQueryParam() {
		List<TicketPrice> tickets = repository.getTicketsByCategoryWithWorkshop("Regular");
		assertEquals("Regular", tickets.get(0).getPricingCategory().getPricingCategoryName());
		assertTrue(tickets.get(0).getTicketType().getIncludesWorkshop());
	}
}
