package com.techleap.conferencetest.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.techleap.conference.model.Session;
import com.techleap.conference.repository.SessionRepository;

@SpringBootTest
class SessionTests {
	@Autowired
	private SessionRepository repository;
	
	@Test
	void testPagingQuery() {
		Page<Session> sessions = repository.getSessionsWithName("S", 
				PageRequest.of(1, 5, Sort.by(Sort.Direction.DESC, 
						"sessionLength")));
		sessions.get().forEach(session -> 
			assertEquals('S', session.getSessionName().charAt(0)));
	}
}
