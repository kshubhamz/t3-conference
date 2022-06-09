package com.techleap.conference.controller;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techleap.conference.model.Session;
import com.techleap.conference.service.SessionsService;

@RestController
@RequestMapping("/v1/sessions")
public class SessionsController {
	@Autowired
	private SessionsService sessionsService;
	
	@GetMapping
	public List<Session> findAllSpeakers() {
		return sessionsService.getAllSessions();
	}
	
	@GetMapping("{id}")
	public Session findSessionBySessionId(@PathVariable Long id) {
		return sessionsService.getSessionById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Session createSession(@RequestBody Session session) {
		return sessionsService.saveSession(session);
	}
	
	@DeleteMapping("{id}")
	public Map<String, Object> deleteSession(@PathVariable Long id) {
		sessionsService.deleteSessionBySessionId(id);
		return Map.of("message", "Session deleted successfully with ID: " + id,
				"timestamp", Instant.now());
	}
}
