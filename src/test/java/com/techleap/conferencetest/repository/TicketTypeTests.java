package com.techleap.conferencetest.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.techleap.conference.model.TicketType;
import com.techleap.conference.repository.TicketTypeRepository;

@SpringBootTest
class TicketTypeTests {
	@Autowired
	private TicketTypeRepository repository;
	
	@Test
	void testQueryDSLTrueKeyword() {
		List<TicketType> tktTypes = repository.findByIncludesWorkshopTrue();
		assertTrue(tktTypes.get(0).getIncludesWorkshop());
	}
}
