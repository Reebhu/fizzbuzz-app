package com.example.fizzbuzz.dataaccess;

import com.example.fizzbuzz.dataaccess.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RequestDashBoardRepoService {

	@Autowired
	RequestRepository repository;

	public void saveRequestToDB(int int1, int int2, String str1, String str2) {

		int count = 1;
		Long id=null;
		Optional<RequestRecord> optionalRequestDashBoard  = findByParams(int1,int2,str1,str2);

		if(optionalRequestDashBoard.isPresent())
		{
			id = optionalRequestDashBoard.get().getId();
			count = optionalRequestDashBoard.get().getCount() + 1;
		}

		RequestRecord requestRecord = RequestRecord.builder()
		                                           .id(id)
		                                           .int1(int1)
		                                           .int2(int2)
		                                           .str1(str1)
		                                           .str2(str2)
		                                           .count(count)
		                                           .updatedAt(LocalDateTime.now())
		                                           .build();
		repository.save(requestRecord);
	}

	public Optional<RequestRecord> findByParams(int int1, int int2, String str1, String str2)
	{
		return repository.findByInt1AndInt2AndStr1AndStr2(int1,int2,str1,str2);
	}

	public RequestRecord findMostRecentRequest()
	{
		return  repository.findFirstByOrderByUpdatedAtDesc();
	}

	public RequestRecord findMostFequentRequest()
	{
		return repository.findFirstByOrderByCountDesc();
	}
}
