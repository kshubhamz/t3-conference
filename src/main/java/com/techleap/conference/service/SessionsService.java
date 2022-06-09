package com.techleap.conference.service;

import java.util.List;

import com.techleap.conference.model.Session;

public interface SessionsService {

	List<Session> getAllSessions();

	Session getSessionById(Long sessionId);
	
	Session saveSession(Session session);

	void deleteSessionBySessionId(Long sessionId);
	
	Session updateSession(Long sessionId, Session updatedSession);
	
	Session addSpeakerToSession(Long sessionId, Long speakerId);
}