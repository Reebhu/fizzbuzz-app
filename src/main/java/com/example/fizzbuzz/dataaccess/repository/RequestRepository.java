package com.example.fizzbuzz.dataaccess.repository;

import com.example.fizzbuzz.dataaccess.RequestRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<RequestRecord, Long> {
	Optional<RequestRecord> findByInt1AndInt2AndStr1AndStr2(Integer int1, Integer int2, String str1, String str2);

	RequestRecord findFirstByOrderByUpdatedAtDesc();

	RequestRecord findFirstByOrderByCountDesc();

}
