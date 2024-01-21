package com.example.fizzbuzz.queue;

import com.example.fizzbuzz.configs.ActiveMQConfiguration;
import com.example.fizzbuzz.queue.model.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class RequestProducer {
	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendRequest(Integer int1, Integer int2, String str1, String str2){
		RequestDTO request = RequestDTO.builder()
		                                .int1(int1)
		                                .int2(int2)
		                                .str1(str1)
		                                .str2(str2)
		                                .build();
		jmsTemplate.convertAndSend(ActiveMQConfiguration.STATS_TOPIC, request);
	}

}
