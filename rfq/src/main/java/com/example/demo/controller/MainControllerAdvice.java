package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class MainControllerAdvice {
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<String> loginHAndleErrorEntity(){
//		log.info("Invalid User");
		return new ResponseEntity<String>("Invalid User",HttpStatus.FORBIDDEN);
	}

}
