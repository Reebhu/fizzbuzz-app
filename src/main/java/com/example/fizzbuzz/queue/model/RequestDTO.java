package com.example.fizzbuzz.queue.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {

	private int int1;
	private int int2;
	private String str1;
	private String str2;
}
