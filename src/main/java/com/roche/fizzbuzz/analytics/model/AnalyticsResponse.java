package com.roche.fizzbuzz.analytics.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnalyticsResponse {

	private QueryRequest mostFrequentRequest;
	private QueryRequest mostRecentRequest;
}
