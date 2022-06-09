package com.techleap.conference.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@Value("${app.version}")
	private String appVersion;
	
	@GetMapping
	public Map<String, String> getStatus() {
		return Map.of("app-name", "Conference",
				"app-version", appVersion);
	}
}
