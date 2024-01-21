package com.roche.fizzbuzz.dataaccess;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "request_record")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private int int1;

	private int int2;

	private String str1;

	private String str2;

	private int count;

	private LocalDateTime updatedAt;

}
