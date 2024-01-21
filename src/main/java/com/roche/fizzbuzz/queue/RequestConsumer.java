package com.roche.fizzbuzz.queue;

import com.roche.fizzbuzz.configs.ActiveMQConfiguration;
import com.roche.fizzbuzz.dataaccess.RequestDashBoardRepoService;
import com.roche.fizzbuzz.queue.model.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class RequestConsumer {

	@Autowired
	private RequestDashBoardRepoService repoService;

	@JmsListener(destination = ActiveMQConfiguration.STATS_TOPIC)
	public void receiveCustomer(RequestDTO requestDTO) {
		System.out.println(requestDTO);
		repoService.saveRequestToDB(requestDTO.getInt1(),requestDTO.getInt2(), requestDTO.getStr1(), requestDTO.getStr2());
	}
}
