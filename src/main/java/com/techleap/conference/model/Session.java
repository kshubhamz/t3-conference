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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SESSIONS")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SESSION_ID")
	private Long sessionId;

	@Column(name = "SESSION_NAME")
	private String sessionName;

	@Column(name = "SESSION_DESC")
	private String sessionDesc;

	@Column(name = "SESSION_LENGTH")
	private Integer sessionLength;

	@ManyToMany
	@JoinTable(name = "SESSION_SPEAKERS", 
		joinColumns = @JoinColumn(name = "SESSION_ID"), 
		inverseJoinColumns = @JoinColumn(name = "SPEAKER_ID"))
	private List<Speaker> speakers;
	
	public Session(String sessionName, String sessionDesc, Integer sessionLength) {
		this.sessionName = sessionName;
		this.sessionDesc = sessionDesc;
		this.sessionLength = sessionLength;
	}

	public Session() {
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public String getSessionDesc() {
		return sessionDesc;
	}

	public void setSessionDesc(String sessionDesc) {
		this.sessionDesc = sessionDesc;
	}

	public Integer getSessionLength() {
		return sessionLength;
	}

	public void setSessionLength(Integer sessionLength) {
		this.sessionLength = sessionLength;
	}

	public List<Speaker> getSpeakers() {
		return Collections.unmodifiableList(speakers);
	}

	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}
	
	public void addSpeaker(Speaker... speakers) {
		if (this.speakers == null)
			this.speakers = new ArrayList<>();
		this.speakers.addAll(Arrays.asList(speakers));
	}

	@Override
	public String toString() {
		return String.format("Session: { sessionId: %s, sessionName: %s, sessionDesc: %s, sessionLength: %s }",
				sessionId, sessionName, sessionDesc, sessionLength);
	}

}
