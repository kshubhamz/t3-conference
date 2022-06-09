package com.techleap.conferencetest.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.techleap.conference.model.Speaker;
import com.techleap.conference.repository.SpeakerRepository;

@SpringBootTest
class SpeakerTests {
	
	@Autowired
	private SpeakerRepository repository;
	
	@Test
	void testQueryDSLIsNullKeyword() {
		List<Speaker> speakers = repository.findBySpeakerPhotoIsNull();
		assertNull(speakers.get(0).getSpeakerPhoto());
	}
	
	@Test
	void testQueryDSLInKeyword() {
		List<String> companies = List.of("Pluralsight", "Meta", "Google");
		List<Speaker> speakers = repository.findByCompanyIn(companies);
		String speaker1Company = speakers.get(0).getCompany();
		assertTrue(companies.stream()
				.anyMatch(company -> speaker1Company.equals(company)));
	}
	
	@Test
	void testQueryDSLIgnoreCaseKeyword() {
		List<Speaker> speakers = repository.findByCompanyIgnoreCase("pluralsight");
		assertEquals("Pluralsight", speakers.get(0).getCompany());
	}
	
	@Test
	void testQueryDSLOrderByKeyword() {
		List<Speaker> speakers = repository.findByLastNameOrderByFirstNameAsc("Kumar");
		assertTrue(speakers.get(0).getFirstName().compareTo(speakers.get(1).getFirstName()) < 0);
	}
	
	@Test
	void testQueryDSLFirstKeyword() {
		Optional<Speaker> speaker = repository.findFirstByFirstName("Laxmi");
		assertTrue(speaker.isPresent());
		assertEquals("Laxmi", speaker.get().getFirstName());
	}
}
