package com.roche.fizzbuzz.analytics.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestParams {

	private int int1;
	private int int2;
	private String str1;
	private String str2;
}
