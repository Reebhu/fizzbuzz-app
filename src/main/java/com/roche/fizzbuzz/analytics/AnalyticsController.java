package com.roche.fizzbuzz.analytics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("analytics")
public class AnalyticsController {

	@Autowired
	AnalyticsService analyticsService;

	@GetMapping
	public ResponseEntity getAnalytics()
	{
		return ResponseEntity.ok().body(analyticsService.getCompleteAnalytics());
	}

	@GetMapping("recent")
	public ResponseEntity getAnalyticsRecent()
	{
		return ResponseEntity.ok().body(analyticsService.getMostRecentRequest());
	}

	@GetMapping
	public ResponseEntity getAnalyticsFrequent()
	{
		return ResponseEntity.ok().body(analyticsService.getMostFrequentRequest());
	}
}
