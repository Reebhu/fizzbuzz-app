package com.example.fizzbuzz.core.controller;

import com.example.fizzbuzz.core.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fizzbuzz")
public class FizzBuzzController {

	@Autowired
	private FizzBuzzService service;

	@GetMapping("/get/{limit}")
	public ResponseEntity getFizzBuzz(@RequestParam Integer int1, @RequestParam Integer int2, @RequestParam String str1, @RequestParam String str2,
	                                  @PathVariable Integer limit)
	{

		return ResponseEntity.ok().body(service.createFizzBuzz(int1,int2,limit,str1,str2));
	}
}
