package com.techleap.conference.service;

import java.util.List;

import com.techleap.conference.model.Speaker;

public interface SpeakersService {

	List<Speaker> getAllSpeakers();

	Speaker getSpeakerById(Long speakerId);
	
	Speaker createSpeaker(Speaker speaker);
	
	void deleteSpeakerById(Long speakerId);
	
	Speaker updateSpeaker(Long speakerId, Speaker updatedSpeaker);
}