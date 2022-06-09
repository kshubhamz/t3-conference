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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techleap.conference.model.Speaker;
import com.techleap.conference.service.SpeakersService;

// TODO : Create Speaker DTO

@RestController
@RequestMapping("/v1/speakers")
public class SpeakersController {
	@Autowired
	private SpeakersService speakersService;
	
	@GetMapping
	public List<Speaker> findAllSpeakers() {
		return speakersService.getAllSpeakers();
	}
	
	@GetMapping("{speakerId}")
	public Speaker findSpeakerBySpeakerId(@PathVariable("speakerId") Long id) {
		return speakersService.getSpeakerById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Speaker createSession(@RequestBody Speaker speaker) {
		return speakersService.createSpeaker(speaker);
	}
	
	@DeleteMapping("{id}")
	public Map<String, Object> deleteSession(@PathVariable Long id) {
		speakersService.deleteSpeakerById(id);
		return Map.of("message", "Apeaker deleted successfully with ID: " + id,
				"timestamp", Instant.now());
	}
	
	@PutMapping("{id}")
	public Speaker updateSession(@PathVariable Long id, @RequestBody Speaker speaker) {
		return speakersService.updateSpeaker(id, speaker);
	}
}
