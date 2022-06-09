package com.techleap.conference.service;

import java.util.List;

import com.techleap.conference.model.Speaker;

public interface SpeakersService {

	List<Speaker> getAllSpeakers();

	Speaker getSpeakerById(Long speakerId);

}