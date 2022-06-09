package com.techleap.conference.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SPEAKERS")
public class Speaker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SPEAKER_ID")
	private Long speakerId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "COMPANY")
	private String company;

	@Column(name = "SPEAKER_BIO")
	private String speakerBio;

	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	@Column(name = "SPEAKER_PHOTO")
	private byte[] speakerPhoto;

	@JsonIgnore
	@ManyToMany(mappedBy = "speakers")
	private List<Session> sessions;
	
	public Speaker(String firstName, String lastName, String title, String company, String speakerBio,
			byte[] speakerPhoto) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.company = company;
		this.speakerBio = speakerBio;
		this.speakerPhoto = speakerPhoto;
	}

	public Speaker(String firstName, String lastName, String title, String company, String speakerBio) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.company = company;
		this.speakerBio = speakerBio;
	}
	
	public Speaker(String firstName, String lastName, String title) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
	}

	public Speaker(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Speaker() {
	}

	public Long getSpeakerId() {
		return speakerId;
	}

	public void setSpeakerId(Long speakerId) {
		this.speakerId = speakerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSpeakerBio() {
		return speakerBio;
	}

	public void setSpeakerBio(String speakerBio) {
		this.speakerBio = speakerBio;
	}

	public byte[] getSpeakerPhoto() {
		return speakerPhoto;
	}

	public void setSpeakerPhoto(byte[] speakerPhoto) {
		this.speakerPhoto = speakerPhoto;
	}

	public List<Session> getSessions() {
		return Collections.unmodifiableList(sessions);
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	public void addSession(Session... sessions) {
		if (this.sessions == null)
			this.sessions = new ArrayList<>();
		this.sessions.addAll(Arrays.asList(sessions));
	}

	@Override
	public String toString() {
		return String.format("Speaker: { speakerId: %s, firstName: %s, lastName: %s }", speakerId, firstName, lastName);
	}

}
