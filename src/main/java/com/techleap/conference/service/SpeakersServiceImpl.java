package com.techleap.conference.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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

	@Override
	public void deleteSpeakerById(Long speakerId) {
		speakerRepository.deleteById(speakerId);
	}

	@Override
	public Speaker updateSpeaker(Long speakerId, Speaker updatedSpeaker) {
		Optional<Speaker> speakerOpt = speakerRepository.findById(speakerId);
		if (speakerOpt.isEmpty())
			return new Speaker("Shubham", "Singh");
		Speaker speaker = speakerOpt.get();
		BeanUtils.copyProperties(updatedSpeaker, speaker, "speakerId", "speakerPhoto", "sessions");
		return speakerRepository.save(speaker);
	}

	@Override
	public Speaker createSpeaker(Speaker speaker) {
		return speakerRepository.save(speaker);
	}
}
