package com.techleap.conference.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techleap.conference.model.Session;
import com.techleap.conference.model.Speaker;
import com.techleap.conference.repository.SessionRepository;
import com.techleap.conference.repository.SpeakerRepository;

@Service
public class SessionsServiceImpl implements SessionsService {
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private SpeakerRepository speakerRepository;
	
	@Override
	public List<Session> getAllSessions() {
		return sessionRepository.findAll();
	}
	
	@Override
	public Session getSessionById(Long sessionId) {
		Optional<Session> session = sessionRepository.findById(sessionId);
		if(session.isEmpty()) {
			Session defaultSession = new Session("Default Session", "No any Session with ID: " + sessionId, 0);
			defaultSession.setSpeakers(List.of(new Speaker("Laxmi", "Apte")));
			return defaultSession;
		} 
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

	@Override
	public Session updateSession(Long sessionId, Session updatedSession) {
		Optional<Session> sessionOpt = sessionRepository.findById(sessionId);
		if (sessionOpt.isEmpty()) {
			Session defaultSession = new Session("Default Session", "No any Session with ID: " + sessionId, 0);
			defaultSession.setSpeakers(List.of(new Speaker("Laxmi", "Apte")));
			return defaultSession;
		}
		Session session = sessionOpt.get();
		BeanUtils.copyProperties(updatedSession, session, "sessionId", "speakers");
		return sessionRepository.save(session);
	}

	@Override
	public Session addSpeakerToSession(Long sessionId, Long speakerId) {
		Optional<Session> sessionOpt = sessionRepository.findById(sessionId);
		Optional<Speaker> speakerOpt = speakerRepository.findById(speakerId);
		if (sessionOpt.isEmpty() || speakerOpt.isEmpty()) {
			Session defaultSession = new Session("Default Session", "No any Session with ID: " + sessionId, 0);
			defaultSession.setSpeakers(List.of(new Speaker("Laxmi", "Apte")));
			return defaultSession;
		}
		Session session = sessionOpt.get();
	
		Speaker speaker = speakerOpt.get();
		
		boolean isSpeakerAlreadyExist = session.getSpeakers().stream()
			.anyMatch(sessionSpeaker -> 
			speaker.getSpeakerId().equals(sessionSpeaker.getSpeakerId()));
		
		if (!isSpeakerAlreadyExist)
			session.addSpeaker(speaker);
		
		return sessionRepository.save(session);
	}
}
