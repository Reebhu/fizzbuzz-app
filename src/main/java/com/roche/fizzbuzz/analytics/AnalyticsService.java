package com.roche.fizzbuzz.analytics;

import com.roche.fizzbuzz.analytics.model.AnalyticsResponse;
import com.roche.fizzbuzz.analytics.model.QueryRequest;
import com.roche.fizzbuzz.analytics.model.RequestParams;
import com.roche.fizzbuzz.dataaccess.RequestDashBoardRepoService;
import com.roche.fizzbuzz.dataaccess.RequestRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

	@Autowired
	RequestDashBoardRepoService repoService;

	public AnalyticsResponse getCompleteAnalytics() {

		return AnalyticsResponse.builder()
		                        .mostFrequentRequest(getMostFrequentRequest())
		                        .mostRecentRequest(getMostRecentRequest())
		                        .build();
	}

	public QueryRequest getMostRecentRequest() {
		RequestRecord mostRecentRecord = repoService.findMostRecentRequest();
		return QueryRequest.builder()
		                   .hits(mostRecentRecord.getCount())
		                   .request(RequestParams.builder()
		                                         .int1(mostRecentRecord.getInt1())
		                                         .int2(mostRecentRecord.getInt2())
		                                         .str1(mostRecentRecord.getStr1())
		                                         .str2(mostRecentRecord.getStr2())
		                                         .build())
		                   .build();
	}

	public QueryRequest getMostFrequentRequest() {
		RequestRecord mostFrequestRecord = repoService.findMostFequentRequest();

		return QueryRequest.builder()
		                   .hits(mostFrequestRecord.getCount())
		                   .request(RequestParams.builder()
		                                         .int1(mostFrequestRecord.getInt1())
		                                         .int2(mostFrequestRecord.getInt2())
		                                         .str1(mostFrequestRecord.getStr1())
		                                         .str2(mostFrequestRecord.getStr2())
		                                         .build())
		                   .build();
	}

}
