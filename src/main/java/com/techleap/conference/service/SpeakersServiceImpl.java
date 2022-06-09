package com.techleap.conference.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techleap.conference.model.Speaker;
import com.techleap.conference.repository.SpeakerRepository;

@Service
public class SpeakersServiceImpl implements SpeakersService {
	@Autowired
	private SpeakerRepository speakerRepository;

	@Override
	public List<Speaker> getAllSpeakers() {
		return speakerRepository.findAll();
	}
	
	@Override
	public Speaker getSpeakerById(Long speakerId) {
		Optional<Speaker> speaker = speakerRepository.findById(speakerId);
		if (speaker.isEmpty())
			return new Speaker("Shubham", "Singh");
		else
			return speaker.get();
	}
}
