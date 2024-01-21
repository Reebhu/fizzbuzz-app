package com.roche.fizzbuzz.core;

import com.roche.fizzbuzz.queue.RequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FizzBuzzService {

	@Autowired
	RequestProducer requestProducer;

	public List<String> createFizzBuzz(int integer1, int integer2, int limit, String string1, String string2)
	{
		List<String> result = new ArrayList<>();

		for(int i=1; i<=limit; i++)
		{
			StringBuilder stringBuilder = new StringBuilder();
			if(i%integer1 == 0)
			{
				stringBuilder.append(string1);
			}
			if (i%integer2 ==0)
			{
				stringBuilder.append(string2);
			}
			if(stringBuilder.isEmpty())
			{
				stringBuilder.append(i);
			}
			result.add(stringBuilder.toString());
		}
		saveRequest(integer1, integer2, string1,string2);
		return result;
	}

	private void saveRequest(int int1, int int2, String str1, String str2) {
		requestProducer.sendRequest(int1,int2,str1,str2);
	}
}
