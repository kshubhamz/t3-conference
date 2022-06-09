package com.techleap.conference.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techleap.conference.model.Session;
import com.techleap.conference.repository.SessionRepository;

@Service
public class SessionsServiceImpl implements SessionsService {
	@Autowired
	private SessionRepository sessionRepository;
	
	@Override
	public List<Session> getAllSessions() {
		return sessionRepository.findAll();
	}
	
	@Override
	public Session getSessionById(Long sessionId) {
		Optional<Session> session = sessionRepository.findById(sessionId);
		if(session.isEmpty())
			return new Session("Default Session", "No any Session with ID: " + sessionId, 0);
		else
			return session.get();
	}

	@Override
	public Session saveSession(Session session) {
		return sessionRepository.save(session);
	}

	@Override
	public void deleteSessionBySessionId(Long sessionId) {
		sessionRepository.deleteById(sessionId);
	}
}
