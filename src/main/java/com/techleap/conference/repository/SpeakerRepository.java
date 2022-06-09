package com.techleap.conference.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techleap.conference.model.Speaker;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
	public List<Speaker> findByFirstNameAndLastName(String firstName, String lastName);

	public List<Speaker> findByFirstNameOrLastName(String firstName, String lastName);
	
	public List<Speaker> findBySpeakerPhotoIsNull();
	
	public List<Speaker> findByCompanyIn(List<String> companies);
	
	public List<Speaker> findByCompanyIgnoreCase(String company);
	
	public List<Speaker> findByLastNameOrderByFirstNameAsc(String lastName);
	
	public Optional<Speaker> findFirstByFirstName(String firstName);
}
