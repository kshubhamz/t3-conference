package com.techleap.conference.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techleap.conference.model.Speaker;
import com.techleap.conference.service.SpeakersService;

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
}
